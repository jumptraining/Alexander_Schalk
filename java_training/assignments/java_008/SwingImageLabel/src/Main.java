// A simple Swing Program
import javax.swing.SwingUtilities;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
public class Main {

	public static JFrame setFrameStuff(JFrame frm, int width, int height, int onExit) {
		frm.setSize(width, height);
		frm.setDefaultCloseOperation(onExit);
		JLabel label = new JLabel();
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.HORIZONTAL);
		ImageIcon fungiImg = new ImageIcon(new ImageIcon("C:\\java_training\\Java_008-training files\\SwingImageLabel\\src\\fungi.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		label.setIcon(fungiImg);
		frm.add(label);
		return frm;
	}
	
	public static void main(String args[]) {
	

		SwingUtilities.invokeLater(new Runnable() {
			SwingDemo demo;
			JFrame frm;
			public void run() {
				demo = new SwingDemo("Swing Image Label Demo");
				frm = demo.getFrame();
				frm = setFrameStuff(frm, 600, 600, JFrame.EXIT_ON_CLOSE);
				frm.setVisible(true);
			}
		});
	}
}