package secondPass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CreateFrame extends JPanel {


    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    boolean created = false;

    public CreateFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("My 2nd Matrix Demo");

                frame.setLayout(new BorderLayout());
                //frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(1200, 900));

                // Display the frame.
                frame.pack();
                frame.setVisible(true);

                //show title at the top
                JPanel topPanel = new JPanel();
                JLabel title = new JLabel("My 2nd Matrix Demo");
                title.setFont(new Font("Arial", Font.PLAIN, 24));
                topPanel.setBounds(600, 0, 1200, 100);
                topPanel.add(title);
                frame.add(topPanel, BorderLayout.PAGE_START);


                //panelJscrl for JScroll
                JPanel panelJscrl = new JPanel();
                panelJscrl.setBounds(50, 100, 150, 500);
                panelJscrl.setBackground(Color.GRAY);

                //testing ListDemo
                //JList <String> jlst;
                JScrollPane jscrlp;

                // Create a JList.
                //jlst = new JList <String>(Client.names);

                // Set the list selection mode to single-selection.
                JListStuff.jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                // Add list to a scroll pane.
                jscrlp = new JScrollPane(JListStuff.jlst);

                // Set the preferred size of the scroll pane.
                jscrlp.setPreferredSize(new Dimension(150, 500));
                // Make a label that displays the selection.
                //jlab = new JLabel("Please choose a name");
                jscrlp.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);
                // Add the list and label to the content pane.

                //add jscroll's panelJscrl to frame
                panelJscrl.add(jscrlp);
                frame.add(panelJscrl, BorderLayout.LINE_START);
 
                //create new panel for seating
                JPanel bigPanel = new JPanel();
                SeatingGrid sg = new SeatingGrid(bigPanel);                
                //bigPanel.setBounds(30, 10, 100, 500);
                bigPanel.setBackground(Color.GRAY);

                //call SeatingGrid class and add to bigPanel
                sg = new SeatingGrid(bigPanel);
                bigPanel.add(sg);
                
                //call function!!!
                bigPanelFunction(bigPanel, sg);         
                
                //add bigPanel to frame
                frame.add(bigPanel, BorderLayout.CENTER);

                //create new panel for reset and print buttons
                JPanel bottomPanel = new JPanel();
                
                //create new buttons
                Client.resetMatrix = new JButton("Reset Entire Matrix");
                Client.resetMatrix.setFont(new Font("Arial", Font.PLAIN, 20));
                Client.printList = new JButton("Print List of Assigned Clients in Console");
                Client.printList.setFont(new Font("Arial", Font.PLAIN, 20));
                bottomPanel.add(Client.resetMatrix);
                bottomPanel.add(Client.printList);

                bottomPanel.add(new ResetPrint(bigPanel, sg));

                //add bottomPanel to frame
                frame.add(bottomPanel, BorderLayout.PAGE_END);

            }
        });
    }

	public static void bigPanelFunction(JPanel bigPanel, SeatingGrid sg) {
        bigPanel = new JPanel();
        
        //bigPanel.setBounds(30, 10, 100, 500);
        bigPanel.setBackground(Color.GRAY);

        //call SeatingGrid class and add to bigPanel
        sg = new SeatingGrid(bigPanel);
        bigPanel.add(sg);
	}
}