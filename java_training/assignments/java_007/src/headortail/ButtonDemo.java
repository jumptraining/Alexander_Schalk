package headortail;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonDemo implements ActionListener {
	JLabel jlab;
	String first;
	String second;
	String firstMsg;
	String secondMsg;
	//public String outcome
	
	//lambda returns 1 or 2
	MyFlip firstLambda = () -> {
		// using Math.random()
		int value = (int)(Math.random() * 2 + 1);
		return value;
	};
	
	//lambda returns Head or Tail
	Coin secondLambda = (value) -> {
		String face = value == 1? "Head" : "Tail";
		return face;
	};

	public String getOutcome() {
		// TODO Auto-generated method stub
		String outcome = secondLambda.face(firstLambda.flip());
		return outcome;
	}

	public void setButtons(JPanel frm, String f, String s, String fMsg, String sMsg) {
		first = f;
		second = s;
		firstMsg = fMsg;
		secondMsg = sMsg;
		
		JButton jbtnFlip = new JButton(first);
		JButton jbtnReset = new JButton(second);
		// Add action listeners.
		jbtnFlip.addActionListener(this);
		jbtnReset.addActionListener(this);
		// Add the buttons to the content pane.
		frm.add(jbtnFlip);
		frm.add(jbtnReset);
		// Create a label.
		jlab = new JLabel("waiting...");
		// Add the label to the frame.
		frm.add(jlab);
	}
	
	// Handle button events.

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(first)) {
			jlab.setText(firstMsg + getOutcome());
		} else {
			jlab.setText(secondMsg);
		}
	}
}
