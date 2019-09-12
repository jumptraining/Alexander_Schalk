package secondPass;

import java.util.Random;

public class InputandDisplay {
    //start of doStuff Method
    public static void doStuff() {

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
        for (Client c: store) {
            if (c != null) {
                System.out.println(c.getFullClientString());
            }
        }

        System.out.println("Randomnized seating in 2d array:");
        System.out.printf("%-15s", "");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%-15s", "Seat " + i);
        }
        System.out.println();

        int row = 0, col = 0, count = 0;
        char ch = 'A';

        for (Client cli: store) {
            if (cli != null) {

                Client.setMatrix(row, col, cli.getClientId() + "/" + cli.getClientInitials());

                //seems to be working
                Client.setNames(cli.getNames(), count);
                count++;
                col++;
                if (col == 10) {
                    col = 0;
                    row++;
                }
            }
        }
        //then Randomnize.shuffle
        ShufflenSwap.shuffle(Client.matrix, 10, new Random());
        //then print out stuff
        for (int r0w = 0; r0w < 10; r0w++) {
            for (int c0l = 0; c0l < 10; c0l++) {
                if (c0l == 0) {
                    System.out.printf("%-15s", "Row " + ch);
                }
                if (Client.matrix[r0w][c0l] != null) {
                    Client.setSeatNumber(Client.matrix[r0w][c0l], (ch), c0l + 1);        
                }
                System.out.printf("%-15s", Client.matrix[r0w][c0l] == null ? "vacant" : Client.matrix[r0w][c0l]);
                Client.booked[r0w][c0l] = (Client.matrix[r0w][c0l] == null ? "book" : "unbook");
            }
            ch++;
            System.out.println();
            //Client.printBooked(Client.booked, r0w);
        }
    } //end of InputandDisplay()
}
