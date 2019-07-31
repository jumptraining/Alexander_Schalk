package gameofdice;
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
	int[] num = new int[4];

	//lambda generates random number 1-6 for each element in array
	MyDice<?> myLambda = (num) -> {
        for (int i = 0; i < num.length; i++) {
            num[i] = (int)(Math.random() * 6 + 1);
        }
        return num;
	};	
	
	public String getDice() {
		// TODO Auto-generated method stub
        myLambda.roll(num);
		//String outcome = myLambda.roll(num);
		return num[0] + " and " + num[1] + ". I rolled " + num[2] + " and " + num[3] + ". ";
	}

	public String getMessages() {
		// TODO Auto-generated method stub
		//String outcome = myLambda.roll(num);
        if (num[0] + num[1] == num[2] + num[3]) {
            if (num[0] == num[1] && num[2] != num[3]) {
            	return "Damn! You win on a Double! What Luck! Did you cheat?? Gimme another try, c’mon.";
            } else if (num[0] != num[1] && num[2] == num[3]) {
            	return "Damn! I win on a Double! Ah! I pity you fool! Wanna try again?";
            } else {
            	return "Stalemate! You’re tough, let’s try for a tie-breaker.";
            }
        } else if (num[0] + num[1] < num[2] + num[3]) {
        	return "I win!!! Wanna try again?";
        } else {
        	return "You win!!! Did you cheat?? Gimme another try, c’mon.";
        }
	}
	
	public void setButtons(JPanel frm, String f, String s, String fMsg, String sMsg) {
		first = f;
		second = s;
		firstMsg = fMsg;
		secondMsg = sMsg;
		
		JButton jbtnFlip = new JButton(first);
		JButton jbtnReset = new JButton(second);
		// Add action listeners.ex
		jbtnFlip.addActionListener(this);
		jbtnReset.addActionListener(this);
		// Add the buttons to the content pane.
		frm.add(jbtnFlip);
		frm.add(jbtnReset);
		// Create a label.
		jlab = new JLabel("Welcome to the dice throw challenge!");
		// Add the label to the frame.
		frm.add(jlab);
	}
	
	// Handle button events.

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(first)) {
			jlab.setText(firstMsg + getDice() + getMessages());
		} else {
			jlab.setText(secondMsg);
		}
	}
}
