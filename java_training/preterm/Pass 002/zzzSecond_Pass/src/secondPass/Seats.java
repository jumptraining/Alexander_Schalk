package secondPass;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Seats {
	
    public static void LabelandButton(String label, String button, int i, int j) {
    	
        //System.out.println("Client flag: " + Client.getFlag(i, j));

        JLabel seatInfo = new JLabel(label);

        seatInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        seatInfo.setFont(new Font("Arial", Font.PLAIN, 12));
        seatInfo.setSize(50, 25);
        seatInfo.setVisible(true);
        Client.seatPanel[i][j].add(seatInfo);
        
        JButton butt = new JButton(button);

        butt.setAlignmentX(Component.CENTER_ALIGNMENT);
        butt.setFont(new Font("Arial", Font.PLAIN, 12));
        butt.setSize(50, 25);
        butt.setVisible(true);
        Client.seatPanel[i][j].add(butt);

    	if(Client.getReset() == false) {
    		Client.setFlag(i, j, Client.getMatrix(i, j) != null ? true : false);
    	} else if(Client.getReset() == true) {
    		Client.setFlag(i, j, false);
    	}

        //button action listener stuff
        butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Client.getFlag(i, j) == false) {
                    Client.setFlag(i, j, true);
                    Client.setMatrix(i, j, "NEW ENTRY");
                    //somehow I need to get the entry to match a person
                    //selected in JScroll and only allow entry if person is selected
                    //and remove person from the Jscroll and update the seating info accordingly
                    seatInfo.setText(Client.getMatrix(i, j));

                    Client.setBooked(i, j, "unbook");
                    butt.setText(Client.getBooked(i, j));

                } else if (Client.getFlag(i, j) == true || Client.getReset() == true) {
                    Client.setFlag(i, j, false);
                    Client.setMatrix(i, j, null);
                    seatInfo.setText("vacant");

                    Client.setBooked(i, j, "book");
                    butt.setText(Client.getBooked(i, j));
                }
            }
        });
    }
}