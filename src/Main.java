import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main {
    static int firstNum, secondNum;
    static NumberGrid myNumberGrid;
    static int numTries; /* Number of tries the player takes to guess correct number */


    static Logic l1 = new Logic();
    static Logic l2 = new Logic();

    static JTextField txt1, txt2;

    public static void main(String[] args) {
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
        txt1 = new JTextField(20);
        txt2 = new JTextField(20);

        //Adds components to panel
        northPanel.add(btnReset);
        southPanel.add(btnCheck);
        southPanel.add(txt1);
        southPanel.add(txt2);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(myNumberGrid, BorderLayout.CENTER);
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

    private static void resetGame() {
        numTries = 0;
        Random rand = new Random();
        //Selects each digit of the two digit number individually
        firstNum = rand.nextInt(9) + 1;
        secondNum = rand.nextInt(9) + 1;
        while (firstNum == secondNum) {
            secondNum = rand.nextInt(9) + 1;
        }
        myNumberGrid.resetColors();
        System.out.println(firstNum * 10 + secondNum); //Combines to give computer generated number as a single number

    }

    private static void checkLogic() {
        //Checks game types of inputted digits
    	
    	int guess = Integer.parseInt(txt1.getText()) * 10 + Integer.parseInt(txt2.getText());
        System.out.println(guess);
    	
    	//Check first text field
        if (Integer.parseInt(txt1.getText()) == firstNum) {
            System.out.println("Fermi");
        } else if (Integer.parseInt(txt1.getText()) == secondNum) {
            System.out.println("Pico");
        } else {
        	myNumberGrid.selectRow(guess);
        	System.out.println("Bagel");
        }

        //Check second text field
        if (Integer.parseInt(txt2.getText()) == secondNum) {
            System.out.println("Fermi");
        } else if (Integer.parseInt(txt2.getText()) == firstNum) {
            System.out.println("Pico");
        } else {
        	myNumberGrid.selectColumn(guess);
        	System.out.println("Bagel");
        }

        numTries++;
        System.out.println(numTries);
    }
}
