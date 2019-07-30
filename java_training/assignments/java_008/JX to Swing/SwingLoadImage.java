import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
 
public class SwingLoadImage {
 
  public static void main(String[] arguments) throws IOException {
 
    JPanel panel = new JPanel();
 
    //file location needs to be changed depending on image location
    BufferedImage image = ImageIO.read(new File("C:\\Users\\Name\\Documents\\workspace-spring-tool-suite-4-4.2.2.RELEASE\\HelloDallas\\SwingRefactors\\src\\fungi.png"));
    JLabel label = new JLabel(new ImageIcon(image));
    panel.add(label);
 
    //main window/frame
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Fungi is hilarious!");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    //add the JPanel to the main window
    frame.add(panel); 
 
    frame.pack();
    frame.setVisible(true);
 
  }
}