import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingBasicDemo1 extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//constructor
	public SwingBasicDemo1() {
        initUI();
    }

	//initUI method
    public final void initUI() {

       JPanel panel = new JPanel();
       getContentPane().add(panel);

       panel.setLayout(null);

       JButton helloButton = new JButton("Say 'Hello World'");
       helloButton.setBounds(50, 75, 200, 50);
       helloButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
        	   //print message to console when button is clicked
               System.out.println("Hello World!");
           }
       });

       panel.add(helloButton);

       setTitle("Hello World!");
       setSize(300, 250);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //main method
    public static void main(String[] args) {
            SwingBasicDemo1 swing = new SwingBasicDemo1();
            swing.setVisible(true);
     }
 }