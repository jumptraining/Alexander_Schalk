package BasicSwingJButtonDemo;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonDemo {
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
		JButton jbtnDown = new JButton(second);
		// Add action listeners.
		jbtnUp.addActionListener(e -> {
			jlab.setText(firstMsg);
		});
		jbtnDown.addActionListener(e -> {
			jlab.setText(secondMsg);
		});
		
		// Add the buttons to the content pane.
		frm.add(jbtnUp);
		frm.add(jbtnDown);
		// Create a label.
		jlab = new JLabel("Press a button.");
		// Add the label to the frame.
		frm.add(jlab);
	}
}