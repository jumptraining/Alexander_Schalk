import java.util.ArrayList;

// a client object

public class Client {
	private String lastname;
	private String firstname;
	private int id;
	static ArrayList<String> seatList = new ArrayList<String>(25);
	
	Client(String l, String f, int i) {
		lastname = l;
		firstname = f;
		id = i;
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
	
	String getClientInitials() {
		char[] initialsArr = {' ', ' '};
		initialsArr[0] = firstname.charAt(0);
		initialsArr[1] = lastname.charAt(0); 
		return new String(initialsArr);
	}

	String getFullClientString() {
		String full = ("id: " + id + " lastname: " + lastname + " firstname: " + firstname);
		return full;
	}
	
	static void setSeatNumber(String person, char letter, int num) {
		//not spaced evenly
        seatList.add("ID/Client: " + person + padding(person.length()) + "Seat: " + letter + "-" + num);
	}

	static String padding(int length) {
        StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 25-length; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
	
	static ArrayList<String> getSeatNumber() {
		seatList.forEach(System.out::println);
		return seatList;
	}
}
