import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class SwingRadioButtons extends JFrame
implements ItemListener {

    private static final long serialVersionUID = 1L;
    private JLabel sbar;

    //initializeUI method
    private void initializeUI() {

        JLabel lbl = new JLabel("Radio Buttons");
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        ButtonGroup group = new ButtonGroup();
        
        //4 radio buttons in a button group, Train is default
        JRadioButton rb1 = new JRadioButton("Train", true);
        JRadioButton rb2 = new JRadioButton("Car");
        JRadioButton rb3 = new JRadioButton("Plane");
        JRadioButton rb4 = new JRadioButton("Boat");

        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        group.add(rb4);

        sbar = new JLabel();
        sbar.setFont(new Font("Arial", Font.BOLD, 20));
        
        rb1.addItemListener(this);
        rb2.addItemListener(this);
        rb3.addItemListener(this);
        rb4.addItemListener(this);

        createLayout(lbl, rb1, rb2, rb3, rb4, sbar);

        setSize(300, 200);
        setTitle("Radio Buttons Demo");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //itemStateChanged method
    @Override
    public void itemStateChanged(ItemEvent e) {

        int sel = e.getStateChange();

        if (sel == ItemEvent.SELECTED) {

        	// text will be lower case radio button selection
            JRadioButton button = (JRadioButton) e.getSource();
            String text = button.getText();

            StringBuilder sb = new StringBuilder("");
            sb.append(text.toLowerCase());

            sbar.setText(sb.toString());
        }
    }

    //createLayout method
    private void createLayout(JComponent...arg) {

        JPanel pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(arg[0])
            .addComponent(arg[1])
            .addComponent(arg[2])
            .addComponent(arg[3])
            .addComponent(arg[4])
            .addComponent(arg[5])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(arg[0])
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(arg[1])
            .addComponent(arg[2])
            .addComponent(arg[3])
            .addComponent(arg[4])
            .addPreferredGap(RELATED,
                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(arg[5])

        );
    }

    //main method
    public static void main(String[] args) {

    	SwingUtilities.invokeLater(new Runnable() {
    		SwingRadioButtons radioButton = new SwingRadioButtons();

			@Override
			public void run() {
			// TODO Auto-generated method stub
            radioButton.initializeUI();
            radioButton.setVisible(true);
			}
        });
    }
}