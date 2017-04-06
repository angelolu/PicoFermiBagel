import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.Random;

public class Main {

    static int numTries; /* Number of tries the player takes to guess correct number */
	
	public static void main(String[] args) {
		
		numTries = 0;
		Random rand = new Random();
		
		//Selects each digit of the two digit number individually
        int firstNum = rand.nextInt(9) + 1;
        int secondNum = rand.nextInt(9) + 1;
        
        //Combines to give computer generated number as a single number
        int secretNum = firstNum * 10 + secondNum;
        System.out.println(secretNum);
        
        //Initializes JFrame and JPanel
        JFrame frame = new JFrame("Pico-Fermi-Bagel Game");
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        
        //Initializes GUI elements
        JTextField txt1 = new JTextField(20); /* Text field which the first digit of the number is entered */
        JTextField txt2 = new JTextField(20); /* Text field which the second digit of the number is entered */
        JButton btn = new JButton(); /* Button to check the guessed input from the text fields */
        btn.setSize(1000, 1000);
        panel.add(btn); 
        panel.add(txt1);
        panel.add(txt2);
        
        //Adds panel to frame and opens frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //Initializes game logic for each text field
        Logic l1 = new Logic();
        Logic l2 = new Logic();
        
        //Event listener for the button
        btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        		//Checks game types of inputed digits
        		l1.setLogic(Integer.parseInt(txt1.getText()), firstNum, secondNum);
        		l2.setLogic(Integer.parseInt(txt2.getText()), secondNum, firstNum);
                
        		System.out.println(l1.getState());
                System.out.println(l2.getState());
                
                increment();
        	}
        });
        
        
        
    }
	
	//Increments numTries as a static method
	private static void increment(){
		numTries++;
		System.out.println(numTries);
	}
}
