package gridlayoutchallenge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class gridlayoutchallenge extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static void createAndShowGUI() {

        int rowCount = (int)(Math.random() * 3) + 2;
        int colCount = (int)(Math.random() * 3) + 2;
        System.out.println(rowCount + " rows were generated");
        System.out.println(colCount + " columns were generated");
        
        JFrame frame = new JFrame("Grid Layout Challenge");

        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(colCount * 50 + 80, (rowCount * 50 + 80)));
        //Display the window.
        frame.pack();
        frame.setVisible(true);

        JPanel topRegion = new JPanel();        
        JLabel header = new JLabel("Basic Matrix Demo", JLabel.CENTER);        
        topRegion.add(header);

        JPanel bottomRegion = new JPanel();
        JLabel status = new JLabel("No Seat Selected", JLabel.CENTER);        
        bottomRegion.add(status);
        
        
        JPanel midRegion = new JPanel();
        midRegion.setLayout(new GridLayout(rowCount, colCount));

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                // Set the panel to add buttons
                JPanel cell = new JPanel();
                
                // create a line border with the specified color and width
                Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
                // set the border of this component
                cell.setBorder(border);
                
                // Set the Boxayout to be Y_AXIS from top to down
                BoxLayout boxlayout = new BoxLayout(cell, BoxLayout.Y_AXIS);
                cell.setLayout(boxlayout);
                cell.setPreferredSize(new Dimension(50, 50));
                details(row, col, cell);
                midRegion.add(cell);
                
            }
        }

        frame.add(topRegion, BorderLayout.PAGE_START);
        frame.add(midRegion, BorderLayout.CENTER);
        frame.add(bottomRegion, BorderLayout.PAGE_END);
    }

    static void details(int row, int col, JPanel panel) {

        char ch = 'A';

        String coordinates = (char)(ch + row) + "-" + (col+1);
        
        JLabel label = new JLabel(coordinates);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Arial", Font.BOLD, 8));
        label.setSize(50, 25);
        label.setVisible(true);
        panel.add(label);

        JButton butt = new JButton(coordinates);
        butt.setAlignmentX(Component.CENTER_ALIGNMENT);
        butt.setFont(new Font("Arial", Font.BOLD, 8));
        butt.setSize(50, 25);
        butt.setVisible(true);
        panel.add(butt);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}