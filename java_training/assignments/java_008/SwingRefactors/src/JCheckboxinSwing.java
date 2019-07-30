import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JCheckboxinSwing {
	
	//all labels and frame
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel headLabel;
    private JLabel msgLabel;
    private JLabel allChecked;
    String noneStr = "<none>";

    //3 checkboxes
    JCheckBox chkWeb = new JCheckBox("Web");
    JCheckBox chkDesktop = new JCheckBox("Desktop");
    JCheckBox chkMobile = new JCheckBox("Mobile");

    // Constructor
    public JCheckboxinSwing() {
        mainFrame = new JFrame("JCheckBox Demo");
        mainFrame.setSize(600, 300);
        mainFrame.setLayout(new GridLayout(4, 1));

        headLabel = new JLabel("Select App Deployment Options", JLabel.CENTER);
        headLabel.setFont(new Font("Arial", Font.BOLD, 20));

        msgLabel = new JLabel("Nothing Clicked.", JLabel.CENTER);
        msgLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        allChecked = new JLabel(noneStr, JLabel.CENTER);
        allChecked.setFont(new Font("Arial", Font.BOLD, 20));
		
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        mainFrame.add(headLabel);
        mainFrame.add(mainPanel);
        mainFrame.add(msgLabel);
        mainFrame.add(allChecked);
        mainFrame.setVisible(true);
        
    }

	public void actionPerformed(ActionEvent ae) {
        myHandle((JCheckBox) ae.getSource());
	}
	
    //myHandle method
    public void myHandle(JCheckBox chk) {

    	//code is intended to change the allChecked JLabel based on what is checked
        String stuff = "";
        int count = 0;

        if (chkWeb.isSelected()) {
            System.out.println("Web selected");
            if (count > 0) {
                stuff += ", ";
            }
            stuff += chkWeb.getText();
            count++;
        }

        if (chkDesktop.isSelected()) {
            System.out.println("Desktop selected");
            if (count > 0) {
                stuff += ", ";
            }
            stuff += chkDesktop.getText();
            count++;
        }

        if (chkMobile.isSelected()) {
            System.out.println("Mobile selected");
            if (count > 0) {
                stuff += ", ";
            }
            stuff += chkMobile.getText();
            count++;
        }
        System.out.println(count);
        allChecked.setText((count > 0)? stuff : noneStr);
    }
    
    //doStuff method
    private void doStuff() {

    	//message label changes based on which checkbox was clicked on
        chkWeb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
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
	
    //main method
    public static void main(String[] args) {
    	JCheckboxinSwing swingControlDemo = new JCheckboxinSwing();
        swingControlDemo.doStuff();
    }
}