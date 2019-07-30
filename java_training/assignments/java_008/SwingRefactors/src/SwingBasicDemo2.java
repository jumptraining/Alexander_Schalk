import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingBasicDemo2 extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//constructor
	public SwingBasicDemo2() {
        initUI();
    }

	//initUI method
    public final void initUI() {

       JPanel panel = new JPanel();
       getContentPane().add(panel);

       panel.setLayout(null);

       JLabel myLabel = new JLabel("");     
       myLabel.setBounds(0, 50, 200, 25);
       
       JButton helloButton = new JButton("Say 'Hello World'");
       helloButton.setBounds(0, 25, 200, 25);
       helloButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   //JLabel displays message
        	   myLabel.setText("Hello World!");
           }
       });
       
       JButton resetButton = new JButton("Reset");
       resetButton.setBounds(0, 75, 100, 25);
       resetButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   //JLabel message is removed
        	   myLabel.setText("");
           }
       });

       panel.add(helloButton);
       panel.add(myLabel);
       panel.add(resetButton);
    
       setTitle("2 Buttons and a Label");
       setSize(250, 150);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //main method
    public static void main(String[] args) {
            SwingBasicDemo2 swing = new SwingBasicDemo2();
            swing.setVisible(true);
     }
 }