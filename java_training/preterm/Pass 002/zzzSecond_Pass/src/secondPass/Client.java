package secondPass;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

// a client object

public class Client {

	//constructor
	Client(String l, String f, int i) {
		lastname = l;
		firstname = f;
		id = i;
		clientInitials = this.setClientInitials();
	}
	
	int getClientId() {
		return id;
	}
	
	String getClientLastName() {
		return lastname;
	}
	
	String getClientFirstName() {
		return firstname;
	}
	
	String setClientInitials() {
		char[] initialsArr = {' ', ' '};
		initialsArr[0] = firstname.charAt(0);
		initialsArr[1] = lastname.charAt(0); 
		return new String(initialsArr);
	}
	
	String getClientInitials() {
		return clientInitials;
	}

	String getFullClientString() {
		String full = ("id: " + id + " lastname: " + lastname + " firstname: " + firstname);
		return full;
	}
	
	static ArrayList<String> IDInitSeat = new ArrayList<String>(25);

	//this information will ...
	static void setSeatNumber(String IDinit, char letter, int num) {
        //added line of code
        IDInitSeat.add(IDinit + "\t\t" + letter + "-" + num);
        
	}
		
	//prints out information to console for all clients
	static ArrayList<String> getSeatNumber() {
		
		Collections.sort(IDInitSeat, new NumericalStringComparator());
		for(int n = 0; n < 25; n++) {
			printOutList.add(names[n] + "\t\t" + (names[n].length() > 15? "" : "\t") + IDInitSeat.get(n));
		}
		printOutList.forEach(System.out::println);
		return printOutList;
	}
	
	static String padding(int length) {
        StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 15-length; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	private String lastname;
	private String firstname;
	private String clientInitials;
	private int id;
	private String seat;
	
	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	//added so multiple classes can access them
	static public JButton resetMatrix = new JButton();
	static public JButton printList = new JButton();
	static public JPanel[][] seatPanel = new JPanel[10][10];

	//trying Reset boolean
	static public boolean Reset = false;
    public static void enableReset() {
    	Reset = true;
    }
    public static void disableReset() {
    	Reset = false;
    }
    public static Boolean getReset() {
    	return Reset;
    }
	
	
	//testing 
	public static void setSeatPanel(int i, int j) {
		
        // Set the seatPanel to add buttons
        JPanel panel = new JPanel();
        seatPanel[i][j] = panel;
       
		// Set the Boxayout to be Y_AXIS from top to down
        BoxLayout boxlayout = new BoxLayout(seatPanel[i][j], BoxLayout.Y_AXIS);
        seatPanel[i][j].setLayout(boxlayout);
        seatPanel[i][j].setPreferredSize(new Dimension(50, 50));
        
        // create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.blue, 2);
        // set the border of this component
        seatPanel[i][j].setBorder(border);
		
	}
	
    public static JPanel getSeatPanel(int i, int j) {
    	return seatPanel[i][j];
    }
	

	//static ArrayList<String> seatList = new ArrayList<String>(25);
	static ArrayList<String> printOutList = new ArrayList<String>(25);

	static public String[] names = new String[25];
	static public String[][] matrix = new String[10][10];
    static public String[][] booked = new String[10][10];
    static public Boolean[][] flag = new Boolean[10][10];

    public static void setFlag(int i, int j, Boolean value) {
    	flag[i][j] = value;
    }
    
    public static Boolean getFlag(int i, int j) {
    	return flag[i][j];
    }
    
	public static void setNames(String fullname, int count) {
			names[count] = fullname;
	}
	
	public String getNames() {
		String fullname = firstname + " " + lastname;
		return fullname;
	}
	
    public static void setBooked(int i, int j, String value) {
    	booked[i][j] = value;
    }
    
    public static String getBooked(int i, int j) {
    	return booked[i][j];
    }

	public static void printBooked(String[][] booked, int row) {
		for(int i = 0; i < 10; i++) {
			System.out.print(booked[row][i] + padding((booked[row][i] == "book" ? 4 : 6)));
		}
		System.out.println();
	}
    
    public static void setMatrix(int i, int j, String value) {
    	matrix[i][j] = value;
    }
    
    public static String getMatrix(int i, int j) {
    	return matrix[i][j];
    }
    
}