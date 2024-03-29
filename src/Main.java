// The following code was written by Angelo Lu (20011350) and Hayden Pfeiffer (20014849)

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main {
    static int firstNum, secondNum; // Randomized numbers
    static NumberGrid myNumberGrid;
    static int numTries; // Number of tries the player takes to guess correct number
    static JTextField txt1, txt2;
    static JLabel labelTries, labelTxt1, labelTxt2;
    static JFrame frame;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("Theme not found.");
        }

        //Initializes GUI elements
        myNumberGrid = new NumberGrid();
        //Initializes JFrame and JPanel
        JPanel mainPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel southTxt1Panel = new JPanel(new GridLayout(2, 0));
        JPanel southTxt2Panel = new JPanel(new GridLayout(2, 0));

        mainPanel.setLayout(new BorderLayout());

        //Initializes buttons
        JButton btnReset = new JButton("Reset Game");
        JButton btnCheck = new JButton("Check Input");
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

        //Initializes labels
        labelTries = new JLabel();
        labelTries = new JLabel();
        labelTxt1 = new JLabel();
        labelTxt2 = new JLabel();
        labelTxt1.setHorizontalAlignment(SwingConstants.CENTER);
        labelTxt2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel labelGuess = new JLabel("Guess:");
        labelGuess.setHorizontalAlignment(SwingConstants.RIGHT);

        //Adds components to panel
        northPanel.add(labelTries);
        northPanel.add(btnReset);
        southPanel.add(new JLabel("Guess:"));
        southTxt1Panel.add(txt1);
        southTxt1Panel.add(labelTxt1);
        southTxt2Panel.add(txt2);
        southTxt2Panel.add(labelTxt2);
        southPanel.add(southTxt1Panel);
        southPanel.add(southTxt2Panel);
        southPanel.add(btnCheck);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(myNumberGrid, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        //Adds panel to frame and opens frame
        frame = new JFrame("Pico-Fermi-Bagel Game");
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
        //Reset Labels
        labelTries.setText("Tries: 0");
        labelTxt1.setText("^ Enter a Digit ^");
        labelTxt2.setText("^ Enter a Digit ^");

        //Unblock text boxes
        txt1.setEditable(true);
        txt2.setEditable(true);
        txt1.setText("");
        txt2.setText("");

        //Selects each digit of the two digit number individually
        Random rand = new Random();
        firstNum = rand.nextInt(9) + 1;
        secondNum = rand.nextInt(9) + 1;
        while (firstNum == secondNum) {
            secondNum = rand.nextInt(9) + 1;
        }
        myNumberGrid.resetColors();
        System.out.println(firstNum * 10 + secondNum); //Combines to give computer generated number as a single number
    }

    private static void checkLogic() {
        //Check if the text fields have unique digits (same digits not allowed)
        if (Integer.parseInt(txt1.getText()) != Integer.parseInt(txt2.getText())) {

            //Put guess digits into one number
            int guess = Integer.parseInt(txt1.getText()) * 10 + Integer.parseInt(txt2.getText());

            //Check first text field
            if (Integer.parseInt(txt1.getText()) == firstNum) {
                txt1.setEditable(false); /* Guessed right digit in right position so cannot edit this digit */
                labelTxt1.setText("^ Fermi ^");
            } else if (Integer.parseInt(txt1.getText()) == secondNum) {
                //Cross out numbers ending with this digit
                myNumberGrid.selectColumn(guess);
                labelTxt1.setText("^ Pico ^");
            } else {
                //Cross out numbers starting with this digit
                myNumberGrid.selectRow(guess);
                labelTxt1.setText("^ Bagel ^");
            }

            //Check second text field
            if (Integer.parseInt(txt2.getText()) == secondNum) {
                txt2.setEditable(false); /* Guessed right digit in right position so cannot edit this digit */
                labelTxt2.setText("^ Fermi ^");
            } else if (Integer.parseInt(txt2.getText()) == firstNum) {
                //Cross out numbers starting with this digit
                myNumberGrid.selectRow(guess);
                labelTxt2.setText("^ Pico ^");
            } else {
                //Cross out numbers ending with this digit
                myNumberGrid.selectColumn(guess);
                labelTxt2.setText("^ Bagel ^");
            }


        } else {
            // Logic if both numbers entered was the safe
            if (Integer.parseInt(txt1.getText()) != secondNum) {
                myNumberGrid.selectColumn(Integer.parseInt(txt1.getText()) * 10 + Integer.parseInt(txt1.getText()));
            } else {
                labelTxt1.setText("^ Pico ^");
            }
            if (Integer.parseInt(txt2.getText()) != firstNum) {
                myNumberGrid.selectRow(Integer.parseInt(txt1.getText()) * 10 + Integer.parseInt(txt1.getText()));
            } else {
                labelTxt2.setText("^ Pico ^");
            }
            if (Integer.parseInt(txt2.getText()) == secondNum) {
                txt2.setEditable(false); /* Guessed right digit in right position so cannot edit this digit */
                labelTxt2.setText("^ Fermi ^");
            }
            if (Integer.parseInt(txt1.getText()) == firstNum) {
                txt1.setEditable(false); /* Guessed right digit in right position so cannot edit this digit */
                labelTxt1.setText("^ Fermi ^");
            }

        }

        numTries++;
        labelTries.setText("Guesses: " + numTries);
        // Display win dialog
        if (txt1.isEditable() == false && txt2.isEditable() == false) {
            String plural;
            if (numTries == 1) plural = "try";
            else plural = "tries";
            String message = "You win\nYou took " + numTries + " " + plural;
            JOptionPane.showMessageDialog(frame, message);
            resetGame();
        }
    }
}
