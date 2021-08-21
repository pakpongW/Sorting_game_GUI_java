import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class drawing extends Canvas{
    public void paint(Graphics g) {
        // 1st rows
        g.drawRect(10,10,120,160);
        g.drawRect(130,10,120,160);
        g.drawRect(250,10,120,160);
        g.drawRect(370,10,120,160);

        // 2nd rows
        g.drawRect(10,170,120,160);
        g.drawRect(130,170,120,160);
        g.drawRect(250,170,120,160);
        g.drawRect(370,170,120,160);

        // 3rd rows
        g.drawRect(10,330,120,160);
        g.drawRect(130,330,120,160);
        g.drawRect(250,330,120,160);
        g.drawRect(370,330,120,160);

    }
}

public class board implements MouseListener{

    public static String board[][] = {{"A","B","C","D"},{"E","F","G","H"},{"I","J","K"," "}};
    public static String save_board[] = {"A","B","C","D","E","F","G","H","I","J","K"," "};
    public static String sorted_board[][] = {{"A","B","C","D"},{"E","F","G","H"},{"I","J","K"," "}};
    public JFrame f;
    public static void main(String[] args) {
        random_board();
        board j = new board();
        j.setup();
    }

    public void setup(){
        f=new JFrame("Sorting_Game");
        drawing d = new drawing();
        // l_0
        JLabel l_0 = new JLabel();
        l_0.setBounds(35,40,90,100);
        l_0.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_1
        JLabel l_1 = new JLabel();
        l_1.setBounds(155,40,90,100);
        l_1.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_2
        JLabel l_2 = new JLabel();
        l_2.setBounds(275,40,90,100);
        l_2.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_3
        JLabel l_3 = new JLabel();
        l_3.setBounds(395,40,90,100);
        l_3.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_4
        JLabel l_4 = new JLabel();
        l_4.setBounds(35,200,90,100);
        l_4.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_5
        JLabel l_5 = new JLabel();
        l_5.setBounds(155,200,90,100);
        l_5.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_6
        JLabel l_6 = new JLabel();
        l_6.setBounds(275,200,90,100);
        l_6.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_7
        JLabel l_7 = new JLabel();
        l_7.setBounds(395,200,90,100);
        l_7.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_8
        JLabel l_8 = new JLabel();
        l_8.setBounds(35,360,90,100);
        l_8.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_9
        JLabel l_9 = new JLabel();
        l_9.setBounds(155,360,90,100);
        l_9.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_10
        JLabel l_10 = new JLabel();
        l_10.setBounds(275,360,90,100);
        l_10.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        // l_11
        JLabel l_11 = new JLabel();
        l_11.setBounds(395,360,90,100);
        l_11.setFont(new Font("Sample glyphs",Font.BOLD, 90));

        f.add(l_0);f.add(l_1);f.add(l_2);f.add(l_3);
        f.add(l_4);f.add(l_5);f.add(l_6);f.add(l_7);
        f.add(l_8);f.add(l_9);f.add(l_10);f.add(l_11);
        f.add(d);

        f.addMouseListener(this);
        f.setSize(510,535);
        f.setVisible(true);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){
            l_0.setText(board[0][0]);l_1.setText(board[0][1]);l_2.setText(board[0][2]);l_3.setText(board[0][3]);
            l_4.setText(board[1][0]);l_5.setText(board[1][1]);l_6.setText(board[1][2]);l_7.setText(board[1][3]);
            l_8.setText(board[2][0]);l_9.setText(board[2][1]);l_10.setText(board[2][2]);l_11.setText(board[2][3]);
        }


    }

    @Override
    public void mouseClicked(MouseEvent ev) {
        String temp = "X";
        int mY = ev.getX() / 120;
        int mX = ev.getY() / 160;
        try{
            if(mX+1 <= 2 && board[mX+1][mY].equals(" ")){
                temp = board[mX][mY];
                board[mX][mY] = board[mX+1][mY];
                board[mX+1][mY] = temp;
            }
            else if(mX-1 >= 0 && board[mX-1][mY].equals(" ")){
                temp = board[mX][mY];
                board[mX][mY] = board[mX-1][mY];
                board[mX-1][mY] = temp;
            }

            else if(mY+1 <= 3 && board[mX][mY+1].equals(" ")){
                temp = board[mX][mY];
                board[mX][mY] = board[mX][mY+1];
                board[mX][mY+1] = temp;
            }

            else if(mY-1 >= 0 && board[mX][mY-1].equals(" ")){
                temp = board[mX][mY];
                board[mX][mY] = board[mX][mY-1];
                board[mX][mY-1] = temp;
            }
            if(check_winner() == true){
                f.setVisible(false);
                JFrame winner = new JFrame("Sorting_Game");
                JLabel lwin = new JLabel(" You Win!");
                lwin.setBounds(400,250,100,100);
                lwin.setFont(new Font("Sample glyphs",Font.BOLD, 90));
                winner.setVisible(true);
                winner.add(lwin);
                winner.setSize(500,500);
                winner.setResizable(false);
            }

        }

        catch(Exception e){

        }


    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent e) {}

    public static void random_board() {
        String character[] = {"A","B","C","D","E","F","G","H","I","J","K"," "};
        ArrayList<String> boardStr = new ArrayList<String>();
        for (int i = 0; i < 12; i++){
            boardStr.add(character[i]);
        }
        Collections.shuffle(boardStr);
        String rd_board[] = boardStr.toArray(new String[0]);

        int s = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 4; j++){
                board[i][j] = rd_board[s];
                s += 1;
            }
        }
    }

    public static boolean check_winner(){
        if(Arrays.deepEquals(board,sorted_board)) {
            return true;
        }
        else{
            return false;
        }
    }
}