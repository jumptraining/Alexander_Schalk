package BasicSwingDemo3;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class MyLabel {
	private String position;

	MyLabel() {		
	}
	
	JLabel setLabel(String l, String p, JFrame jf) {
		position = p;
		JLabel lb = new JLabel(l);
		setLabelInLayout(jf, lb);
		return lb;
	}
	
	void setLabelInLayout(JFrame jF, JLabel jl) {
		jF.add(jl, position);
	}
}
