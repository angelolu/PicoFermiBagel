import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main{
    static Random rand = new Random();
    static int firstNum, secondNum;
    static NumberGrid myNumberGrid;

    public static void main(String[] args) {
        JPanel mainPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        myNumberGrid = new NumberGrid();

        JButton btnReset = new JButton();
        JButton btnCheck = new JButton();

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLogic();
            }
        });
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        JTextField txt1 = new JTextField(20);
        JTextField txt2 = new JTextField(20);

        northPanel.add(btnReset);
        southPanel.add(txt1);
        southPanel.add(txt2);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(myNumberGrid,BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Pico-Fermi-Bagel Game");
        frame.setSize(500, 900);
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        resetGame();
    }

    private static void resetGame(){
        firstNum = rand.nextInt(9) + 1;
        secondNum = rand.nextInt(9) + 1;
        while (firstNum == secondNum) {
            secondNum = rand.nextInt(9) + 1;
        }
        System.out.println(firstNum * 10 + secondNum);
    }
    private static void checkLogic(){
        //Logic l1 = new Logic(Integer.parseInt(txt1.getText()), firstNum, secondNum);
        //Logic l2 = new Logic(Integer.parseInt(txt2.getText()), secondNum, firstNum);

        //System.out.println(l1.getState());
        //System.out.println(l2.getState());
    }
}
