package gameofdice;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class Main {
	
	public static void centerAndSizeJFrameOnScreen(JFrame frm, int width, int height) {
		// set the size of the frame to half in width and height
		frm.setSize(width/2, height/2);
		// here's the part where the JFrame gets actually centered
		frm.setLocationRelativeTo(null);
	}

	public static JFrame setFrameStuff(JFrame frm, int onExit, int width, int height) {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		centerAndSizeJFrameOnScreen(frm, width, height);
		frm.setDefaultCloseOperation(onExit);
		
		JPanel panel1 = new JPanel();
		
		panel1.setLayout(new FlowLayout());
		
		ButtonDemo bd = new ButtonDemo();
		bd.setButtons(panel1, "Roll the Dice!", "Reset", "You rolled ", "Welcome to the dice throw challenge!");
		
		frm.add(panel1);
		return frm;
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			SwingDemo demo;
			JFrame frm;
			
			public void run() {
				demo = new SwingDemo("Game of Dice");
				frm = demo.getFrame();
				frm = setFrameStuff(frm, JFrame.EXIT_ON_CLOSE, 1000, 500);
				frm.setVisible(true);
			}
		});
	}
}