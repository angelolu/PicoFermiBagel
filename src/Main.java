import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main{
    static int firstNum, secondNum;
    static NumberGrid myNumberGrid;
    static int numTries; /* Number of tries the player takes to guess correct number */

    public static void main(String[] args) {
        numTries = 0;

        //Initializes GUI elements
        myNumberGrid = new NumberGrid();
        //Initializes JFrame and JPanel
        JPanel mainPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //Initializes buttons
        JButton btnReset = new JButton();
        JButton btnCheck = new JButton();
        //Event listener for the button
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLogic();
            }
        });

        //Initialize text fields
        JTextField txt1 = new JTextField(20);
        JTextField txt2 = new JTextField(20);

        //Adds components to panel
        northPanel.add(btnReset);
        southPanel.add(txt1);
        southPanel.add(txt2);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(myNumberGrid,BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        //Adds panel to frame and opens frame
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
        Random rand = new Random();
	    //Selects each digit of the two digit number individually
	    firstNum = rand.nextInt(9) + 1;
        secondNum = rand.nextInt(9) + 1;
        while (firstNum == secondNum) {
            secondNum = rand.nextInt(9) + 1;
        }
        System.out.println(firstNum * 10 + secondNum); //Combines to give computer generated number as a single number
    }
    private static void checkLogic(){
        //Logic l1 = new Logic(Integer.parseInt(txt1.getText()), firstNum, secondNum);
        //Logic l2 = new Logic(Integer.parseInt(txt2.getText()), secondNum, firstNum);

        //System.out.println(l1.getState());
        //System.out.println(l2.getState());
        
        //Initializes game logic for each text field
        Logic l1 = new Logic();
        Logic l2 = new Logic();

    }
	
	//Increments numTries as a static method
	private static void increment(){
		numTries++;
		System.out.println(numTries);
	}
}
