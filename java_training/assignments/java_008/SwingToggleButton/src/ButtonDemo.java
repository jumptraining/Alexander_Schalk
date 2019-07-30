import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;

public class ButtonDemo  implements ItemListener {
	JLabel jlab;
	String first;
	String second;
	String firstMsg;
	String secondMsg;
	
	public void setButton(JPanel frm, String f, String fMsg, String sMsg) {
		first = f;
		firstMsg = fMsg;
		secondMsg = sMsg;
		
	
		
		JToggleButton toggler = new JToggleButton(f);
		// Add action listeners.
		toggler.addItemListener(this);
		// Add the buttons to the content pane.
		frm.add(toggler);
		// Create a label.
		jlab = new JLabel("Press a button.");
		// Add the label to the frame.
		frm.add(jlab);
	}
	
	// Handle button events.



	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			jlab.setText(firstMsg);
		}else {
			jlab.setText(secondMsg);
		}
		
		
		
		
	}
}