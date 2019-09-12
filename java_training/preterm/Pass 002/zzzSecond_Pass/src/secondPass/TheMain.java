package secondPass;
import javax.swing.JFrame;

public class TheMain extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public static void main(String[] args) {
    	//first pass console content
    	InputandDisplay.doStuff();
    	
    	//second pass and GUI content
    	new CreateFrame();
    }

}