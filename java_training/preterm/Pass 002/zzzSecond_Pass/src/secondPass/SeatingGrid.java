package secondPass;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


//create the grid
public class SeatingGrid extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SeatingGrid(JPanel bigPanel) {
    	
        setLayout(new GridLayout(11, 11));
        this.setPreferredSize(new Dimension(1000, 500));

        for (int row = 0; row < 11; row++) {

        	JLabel rows = new JLabel((row > 0) ? "ROW " + Character.toString((char)(('A' + row) - 1)) : " ");
        	rows.setHorizontalAlignment(JLabel.CENTER);
        	this.add(rows);

            for (int col = 0; col < 10; col++) {
                if (row == 0) {
                	JLabel columns = new JLabel("Seat " + Integer.toString(col + 1));
                	columns.setHorizontalAlignment(JLabel.CENTER);
                	this.add(columns);
                } else {
            		
                	Client.setSeatPanel(row-1, col);              	

                	if(Client.getReset() == false) {
                		Seats.LabelandButton(Client.getMatrix(row-1, col) == null ? "vacant" : "id: " + Client.getMatrix(row-1, col), Client.getBooked(row-1, col), row-1, col);
                		//System.out.println("in if: " + Client.getReset());
                	} else if(Client.getReset() == true) {
                		//same button and label arguments
                		Seats.LabelandButton("vacant", "book", row-1, col);
                		//System.out.println("In Else: " + Client.getReset());
                	}
            			this.add(Client.getSeatPanel(row-1, col));   			
                }
            }
        }
    }

}