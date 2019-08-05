package secondPass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ResetPrint extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

	public ResetPrint(JPanel bigPanel, SeatingGrid sg) {
		
		//code for the reset button
		Client.resetMatrix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                System.out.println("now reseting matrix");

                //Reset becomes true
                Client.enableReset();
                
                //bigPanel = new SeatingGrid(bigPanel);
                //bigPanel.add(new SeatingGrid(bigPanel));
                CreateFrame.bigPanelFunction(bigPanel, sg);
                new SeatingGrid(bigPanel);
                
                System.out.println("matrix has been reset");
                //Reset becomes false
                Client.disableReset();
            }
		});
		
		//code for the print button
		Client.printList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Clients List and their seating assignment");
            	System.out.println("Client:\t\t\t\tID/Initials:\tSeat:");
            	Client.getSeatNumber();
            }
		});	
	}
}