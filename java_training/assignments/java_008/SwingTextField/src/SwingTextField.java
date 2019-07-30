
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SwingTextField implements ActionListener{
	JTextField jtf; 
	JButton jbtnShow;
	JLabel jlabPrompt, jlabContents;
	
	SwingTextField(){
		
		//creating a new JFrame and setting the label to "Enter some text"
		JFrame jfrm = new JFrame("Enter some text...");
		//adding the FlowLayout to the new JFrame that was just created 
		jfrm.setLayout(new FlowLayout());
		//setting the size of the JFrame 
		jfrm.setSize(300, 200);
		//sets the JFrame to close 
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jtf = new JTextField(10);
		//setting a new action command 
		jtf.setActionCommand("myTF");
		
		
		//creating new JButton with Show label 
		JButton jbtnShow = new JButton("Show");
		//binding events to the textfield and the button 
		jtf.addActionListener(this);
		jbtnShow.addActionListener(this);
		//adding text to prompt user to enter text to the textfield 
		jlabPrompt = new JLabel("Enter text: ");
		
		jlabContents = new JLabel("");
		
		
		//adding all of the created elements to the JFrame 
		jfrm.add(jlabPrompt);
		jfrm.add(jtf);
		jfrm.add(jbtnShow);
		jfrm.add(jlabContents);
		//setting the JFrame boolean to true 
		jfrm.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		//setting the action command to the String variable called action 
		String action = ae.getActionCommand();
		//switch case for defined events 
		switch(action) {
		case "Show":
			String t = jtf.getText();
			//this is for when the user doesnt enter anything and presses the button
			if(t.isEmpty() || t.isBlank()) {
				//this prints to the jlabel 
				jlabContents.setText("Enter something");
			}else {
				//this prints to the jlabel when something is in the text field
				jlabContents.setText(jtf.getText());
			}
			break;
		case "myTF":
			//this captures myTF actionCommand as a work around for the enter button to fire off the event 
			jlabContents.setText(jtf.getText());
			break;
			default:
					System.out.println(action);
		}
	}
	
	public static void main(String []args ) {
		
		//this interface invokes the previously defined TextField to render to the screen
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingTextField();
			}
		});
	}

	
}
