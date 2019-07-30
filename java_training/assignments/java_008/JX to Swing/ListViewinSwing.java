import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListViewinSwing extends JPanel implements ListSelectionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JList list;
    private DefaultListModel listModel;
    public static JLabel headLabel;
    public static JLabel msgLabel;
    private JButton RemoveButton;

    //constructor
    public ListViewinSwing() {
        super(new BorderLayout());

        listModel = new DefaultListModel();
        listModel.addElement("Train");
        listModel.addElement("Car");
        listModel.addElement("Airplane");

        //create list and put it in scroll pane
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);

        JButton AddButton = new JButton("Add an Item");
        AddListener AddListener = new AddListener(AddButton);
        AddButton.addActionListener(AddListener);
        AddButton.setEnabled(true);

        RemoveButton = new JButton("Remove an Item");
        RemoveButton.addActionListener(new RemoveListener());

        //create a panel that uses BoxLayout
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(RemoveButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(AddButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

    //RemoveListener class
    //remove indexes and disable remove button
    class RemoveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = list.getSelectedIndex();
            listModel.remove(index);

            int size = listModel.getSize();

            if (size == 0) {
                RemoveButton.setEnabled(false);
            } else {
                if (index == listModel.getSize()) {
                    index--;
                }

                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        }
    }

    //AddListener class
    class AddListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton butt;

        public AddListener(JButton button) {
            this.butt = button;
        }

        //required by ActionListener
        public void actionPerformed(ActionEvent e) {
            String name = "Test";

            int index = list.getSelectedIndex();
            if (index == -1) {
                index = 0;
            } else {
                index++;
            }

            //insert Test at the index
            listModel.insertElementAt("Test", index);
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }

        //method required by DocumentListener
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        //method required by DocumentListener
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        //method required by DocumentListener
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        //enableButton method
        private void enableButton() {
            if (!alreadyEnabled) {
                butt.setEnabled(true);
            }
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
    }

    //method is required by ListSelectionListener
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            //remove button enabled if selection
            if (list.getSelectedIndex() == -1) {
                RemoveButton.setEnabled(false);

            } else {
                RemoveButton.setEnabled(true);
            }
        }
    }

    //createAndShowGUI method
    private static void createAndShowGUI() {
        //create the frame
        JFrame frame = new JFrame("ListView Demo");
        frame.setPreferredSize(new Dimension(350, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //headLabel added to topPanel
        JPanel topPanel = new JPanel();
        headLabel = new JLabel("Select Transport Type", JLabel.CENTER);
        headLabel.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(headLabel);
        frame.add(topPanel, BorderLayout.NORTH);

        //content pane added to middlePanel
        JPanel middlePanel = new JPanel();
        JComponent newContentPane = new ListViewinSwing();
        newContentPane.setOpaque(true);
        middlePanel.add(newContentPane);
        frame.add(middlePanel, BorderLayout.CENTER);

        //display window
        frame.pack();
        frame.setVisible(true);
    }

    //main method
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}