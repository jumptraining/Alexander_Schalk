import java.util.Random;

public class Main {

	public static void startApp() {
		System.out.println("startApp()");
		System.out.println("\n");
		
	}
	
	public static void getInput() {

		// quick test of the client data structure
		System.out.println("getInput()\n");
		System.out.println("- We are going to create a Client class that will hold data and return itself or some info about it");
		Client testClient = new Client("Gauthier", "Claude", 2);
		System.out.println("Lastname: " + testClient.getClientLastName() + " " + "Firstname: " + testClient.getClientFirstName() + " " + "ID: " + testClient.getClientId());
		System.out.println("\n\n");
		// quick test to see if we can load data from a CSV file
		// and at least get an accurate count of the rows loaded in
		System.out.println("- Testing the ClientStore class\n");
		ClientStore myStore = new ClientStore("clients_list.csv");
		Client[] store = myStore.getClientStore();
		System.out.println("\n");
		System.out.println("- DataCount: " + myStore.getClientDataCount());
		System.out.println("\nThis is a list of all the data in the store\n");

		// iterate via the array of store.
		for(Client c : store) {
			if(c != null) {
				System.out.println(c.getFullClientString());
			}
		}		
	
		System.out.println("Randomized seating in 2d array:");
        System.out.printf("%-25s", "");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%-25s", "Seat " + i);
        }
		System.out.println();
        
		String[][] matrix = new String[10][10];
		int row = 0, col = 0;
		char ch = 'A';
		
		for(Client cli : store) {
			if(cli != null) {

				matrix[row][col] = cli.getClientId() + "/" + cli.getClientInitials();

				col++;
				if(col == 10) {
					col = 0;
					row++;
				}
			}
		}
		//then shuffle
	    Randomize.shuffle(matrix, 10, new Random());
	    //then print out stuff
	    for (int r0w = 0; r0w < matrix.length; r0w++) {
	        for (int c0l = 0; c0l < matrix[r0w].length; c0l++) {
	        	if(c0l == 0) {
	            	System.out.printf("%-25s", "Row " + ch);
	        	}
	                if(matrix[r0w][c0l] != null) {
	                	Client.setSeatNumber(matrix[r0w][c0l], (ch), c0l+1);
	                }
	            System.out.printf("%-25s", matrix[r0w][c0l] == null? "vacant " : matrix[r0w][c0l] + " ");
	        }
	        ch++;
	        System.out.println();
	    }
		System.out.println("Clients List and their seating assignment");
		Client.getSeatNumber();
	}	
	
	public static void main(String[] args) {
		startApp();
		getInput();
	}
}