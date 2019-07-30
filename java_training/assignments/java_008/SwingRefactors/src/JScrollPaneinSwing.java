import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

//JScrollPaneToTopAction class
class JScrollPaneToTopAction implements ActionListener {
    JScrollPane scrollPane;
    public JScrollPaneToTopAction(JScrollPane scrollPane) {
        if (scrollPane == null) {
            throw new IllegalArgumentException(
                "JScrollPaneToTopAction: null JScrollPane");
        }
        this.scrollPane = scrollPane;
    }
    public void actionPerformed(ActionEvent actionEvent) {
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMinimum());
        horizontalScrollBar.setValue(horizontalScrollBar.getMinimum());
    }
}


public class JScrollPaneinSwing {
	//multiple line message for a label
    static String msg = "<html>A ScrollPane streamlines the process <br>" +
        " of adding darn scroll bars to a window whose contents <br>" +
        " exceed the viewing area dimension of the window <br> " +
        " It also enables a control to fit in <br> " +
        " Such as this label control in JavaFX <br> " +
        " Without it, we could not really view well the content <br> " +
        " of a control if it overflowed, so using scrollbars helps lots!</html>";

    //main method
    public static void main(String args[]) {
        JFrame frame = new JFrame("JScrollPane Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //label will be inside scroll pane
        JLabel label = new JLabel(msg);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.TOP);
        label.setPreferredSize(new Dimension(350, 300));
        JScrollPane jScrollPane = new JScrollPane(label);

        //button should be tested when resizing the frame/scroll pane
        JButton bn = new JButton("Reset JScrollPane to Top/Left");

        bn.addActionListener(new JScrollPaneToTopAction(jScrollPane));

        frame.add(bn, BorderLayout.SOUTH);
        frame.add(jScrollPane, BorderLayout.CENTER);
        frame.setSize(400, 150);
        frame.setVisible(true);
    }
}