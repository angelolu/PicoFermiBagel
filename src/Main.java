import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.Random;

public class Main {

    static int numTries;
	
	public static void main(String[] args) {
		
		numTries = 0;
		Random rand = new Random();
		
        int firstNum = rand.nextInt(9) + 1;
        int secondNum = rand.nextInt(9) + 1;
        
        int secretNum = firstNum * 10 + secondNum;
        System.out.println(secretNum);
        
        JFrame frame = new JFrame("Pico-Fermi-Bagel Game");
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        
        JButton btn = new JButton();
        btn.setSize(1000, 1000);
        panel.add(btn);
        JTextField txt1 = new JTextField(20);
        JTextField txt2 = new JTextField(20);
        panel.add(txt1);
        panel.add(txt2);
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        Logic l1 = new Logic();
        Logic l2 = new Logic();
        
        btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		l1.setLogic(Integer.parseInt(txt1.getText()), firstNum, secondNum);
        		l2.setLogic(Integer.parseInt(txt2.getText()), secondNum, firstNum);
                
        		System.out.println(l1.getState());
                System.out.println(l2.getState());
                
                increment();
        	}
        });
        
        
        
    }
	private static void increment(){
		numTries++;
		System.out.println(numTries);
	}
}
