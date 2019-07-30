import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Frame extends JFrame implements ItemListener {
   
	//3 items in combo box
    private JComboBox jb;
    String[] item = {"Train","Car","Airplane"};
    private JLabel headLabel;
    private JLabel msgLabel;

    //frame method
    Frame()
    {
        setTitle("JComboBox Demo");
        setLayout(new FlowLayout());
        setJComboBox();
        setAction();
        setSize(350, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   //setJComboBox method (also sets labels)
    private void setJComboBox()
    {
        headLabel = new JLabel("Select Transport Type", JLabel.CENTER);
        headLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(headLabel);
        jb = new JComboBox(item);
        add(jb);
        msgLabel = new JLabel("", JLabel.CENTER);
        msgLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(msgLabel);
    }
    
    private void setAction()
    {
        jb.addItemListener(this);
    }
    
    //itemStateChanged method 
    public void itemStateChanged(ItemEvent ie)
    {
        String getItem = (String)jb.getSelectedItem();
        //message depends on combo box item
        if(getItem.equals(item[0]))
            msgLabel.setText("Selected: Train");
        else if(getItem.equals(item[1]))
        	msgLabel.setText("Selected: Car");
        else if(getItem.equals(item[2]))
        	msgLabel.setText("Selected: Airplane");
    }
    
}

public class JComboBoxinSwing {
   //main method
    public static void main(String[] args) {     
       new Frame();
    }
}