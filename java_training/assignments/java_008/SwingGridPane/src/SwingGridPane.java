
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class SwingGridPane {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JPanel controlPanel;
	
	public SwingGridPane() {
		prepareGUI();
	}
	
	private void prepareGUI() {
		mainFrame = new JFrame("Grid Layout Demo");
		mainFrame.setSize(340, 240);
		mainFrame.setLayout(new GridLayout(3,1));
		headerLabel = new JLabel("", JLabel.CENTER);
		
		  mainFrame.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
		             // this is the way to force a java application to gracefully exit
		        	 // when not going to end via the main method entry point
		        	 System.exit(0);
		         }        
		      }); 
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);
	}
	
	private void showGridLayout() {
		headerLabel.setText("Push a button");
		JPanel panel = new JPanel();
		panel.setSize(300,300);
		GridLayout layout = new GridLayout(2,3);
		layout.setHgap(5);
		layout.setVgap(5);
		panel.setLayout(layout);
		int length = 6; 
		JButton[] buttons = new JButton[length];
		int x;
		String prefixLabel = "Button ";
		for(x=0; x < length; x++) {
			buttons[x] = new JButton(prefixLabel.concat(Integer.toString(x+1)));
			panel.add(buttons[x]);
			
			
		}
		
		controlPanel.add(panel);
		mainFrame.setVisible(true);
 	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SwingGridPane gridLayoutDemo = new SwingGridPane();
				gridLayoutDemo.showGridLayout();
			}
		});

	}

	
}
