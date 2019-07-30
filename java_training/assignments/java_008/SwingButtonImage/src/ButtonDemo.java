import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import java.io.IOException;

public class ButtonDemo  implements ActionListener {
	JLabel jlab;
	String first;
	String second;
	String firstMsg;
	String secondMsg;
	
	public void setButtons(JPanel frm, String f, String s, String fMsg, String sMsg) {
		first = f;
		second = s;
		firstMsg = fMsg;
		secondMsg = sMsg;
		
		

		
		JButton jbtnUp = new JButton(first);
		try {
			Image dairy = ImageIO.read(getClass().getResource("dairy.png"));
			Image resizedDairy = dairy.getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH);
			
			jbtnUp.setIcon(new ImageIcon(resizedDairy));
			
		}catch(IOException ex) {
			System.out.println(ex);
		}
		JButton jbtnDown = new JButton(second);
		try {
			Image fungi = ImageIO.read(getClass().getResource("fungi.png"));
			Image resizedFungi = fungi.getScaledInstance(28,28,java.awt.Image.SCALE_SMOOTH);
			jbtnDown.setIcon(new ImageIcon(resizedFungi));
			
		}catch(IOException ex) {
			System.out.println(ex);
		}
		
		JButton reset = new JButton("reset");
		reset.setActionCommand("reset");
		// Add action listeners.
		jbtnUp.addActionListener(this);
		jbtnDown.addActionListener(this);
		reset.addActionListener(new resetButtonListener());
		// Add the buttons to the content pane.
		frm.add(jbtnUp);
		frm.add(jbtnDown);
		frm.add(reset);
		// Create a label.
		jlab = new JLabel("Press a button.");
		// Add the label to the frame.
		frm.add(jlab);
	}
	
	// Handle button events.
	public class resetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			
			if(command == "reset") {
				jlab.setText("");
			}
			
		}
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(first)) {
			jlab.setText(firstMsg);
		} else {
			jlab.setText(secondMsg);
		}
	}
}
