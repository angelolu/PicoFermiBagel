import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.Random;

public class Main {

	
	
	public static void main(String[] args) {
		
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
        
        btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		Logic l1 = new Logic(Integer.parseInt(txt1.getText()), firstNum, secondNum);
                Logic l2 = new Logic(Integer.parseInt(txt2.getText()), secondNum, firstNum);
                
                System.out.println(l1.getState());
                System.out.println(l2.getState());
        	}
        });
        
        
        
    }
}
