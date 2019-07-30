import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main{

    private JFrame mainFrame;
    private JLabel headLabel;
    private JLabel msgLabel;
    private JPanel mainPanel;
    String noneStr = "<none>";

    private JLabel allTargets;

    JCheckBox chkWeb = new JCheckBox("Web");
    JCheckBox chkDesktop = new JCheckBox("Desktop");
    JCheckBox chkMobile = new JCheckBox("Mobile");

    // Constructor
    public Main() {
        mainFrame = new JFrame("JCheckBox Demo");
        mainFrame.setSize(600, 300);
        mainFrame.setLayout(new GridLayout(4, 1));

        headLabel = new JLabel("Select App Deployment Options", JLabel.CENTER);
        headLabel.setFont(new Font("Arial", Font.BOLD, 20));

        msgLabel = new JLabel("Nothing Clicked.", JLabel.CENTER);
        msgLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        allTargets = new JLabel(noneStr, JLabel.CENTER);
        allTargets.setFont(new Font("Arial", Font.BOLD, 20));
		
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        mainFrame.add(headLabel);
        mainFrame.add(mainPanel);
        mainFrame.add(msgLabel);
        mainFrame.add(allTargets);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
    	Main swingControlDemo = new Main();
        swingControlDemo.doStuff();
        
    }

    public void myHandle(JCheckBox chk) {

        String stuff = "";
  
        if (chkWeb.isSelected()) {
            System.out.println(chkWeb.getText() + " was selected.");
            stuff += "Web";
            
        }

        if (chkDesktop.isSelected()) {
            System.out.println(chkDesktop.getText() +" was selected.");
           
            stuff += "Desktop";
  
        }

        if (chkMobile.isSelected()) {
            System.out.println(chkMobile.getText() + " was selected");
           
            stuff += "Mobile";
        
        }

       msgLabel.setText("Selected check boxes: " + stuff);
       allTargets.setText(stuff);
    }
    
    private void doStuff() {

        chkWeb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            	System.out.println("I was clicked");
                msgLabel.setText("Clicked: web");
               
            }
        });

        chkDesktop.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                msgLabel.setText("Clicked: desktop");
            }
        });

        chkMobile.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                msgLabel.setText("Clicked: mobile");
            }
        });
    	
        mainPanel.add(chkWeb);
        mainPanel.add(chkDesktop);
        mainPanel.add(chkMobile);
                
        mainFrame.setVisible(true);
    }
    
	public void actionPerformed(ActionEvent ae) {
        myHandle((JCheckBox) ae.getSource());
	}
}