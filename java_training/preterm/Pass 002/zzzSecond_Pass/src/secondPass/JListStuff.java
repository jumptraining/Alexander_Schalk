package secondPass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListStuff extends JPanel implements ListSelectionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // Create jLists.
    static JList <String> jlst = new JList <String> (Client.names);
    static JList <String> fulljList = new JList <String> (Client.names);

    class RemovejListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = jlst.getSelectedIndex();
            jlst.remove(index);

            int size = 25;

            if (size == 0) {
                //butt.setEnabled(false);
            } else {
                if (index == 25) {
                    index--;
                }

                jlst.setSelectedIndex(index);
                jlst.ensureIndexIsVisible(index);
            }
        }
    }

    //AddjListener class
    class AddjListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton butt;


        //method required by DocumentjListener
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }


        //handleEmptyTextField method
        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                butt.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }

        //method is required by jListSelectionjListener
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting() == false) {

                //remove button enabled if selection
                if (jlst.getSelectedIndex() == -1) {
                    butt.setEnabled(false);

                } else {
                    butt.setEnabled(true);
                }
            }
        }


        public void actionPerformed(ActionEvent e) {
            String name = "Test";

            int index = jlst.getSelectedIndex();
            if (index == -1) {
                index = 0;
            } else {
                index++;
            }

            //insert Test at the index
            //fulljList.insertElementAt("Test", index);
            jlst.setSelectedIndex(index);
            jlst.ensureIndexIsVisible(index);
        }


        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enable();
            }
        }


        public void insertUpdate(DocumentEvent e) {
            enable();
        }
        
    }

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}