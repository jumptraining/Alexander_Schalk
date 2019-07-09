package phone;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class phonebook {

    public static void main(String[] myArgs) throws IOException, EmptyEntryException {

        System.out.println("Enter Phonebook Data...");

        Scanner scanner = new Scanner(System.in);
        //defining 2D array to hold phonebook data
        String[][] phonebook = new String[5][3];
        // Enter phonebook data
        enterPhonebookData(scanner, phonebook);

        // Print phonebook data to console
        printPhonebookData(phonebook);

        // also Save phonebook data to file
        savePhonebookData(phonebook);
    }

    public static void enterPhonebookData(Scanner scanner, String[][] phonebook) throws EmptyEntryException {

        String info[] = new String[] {
            "Name",
            "Phone number",
            "City"
        };

        // input 5 rows of data, 3 columns, using keyboard entry

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    System.out.print("Input info for " + info[j % 3] + " on row " + (i + 1) + ":\n");
                    phonebook[i][j] = scanner.nextLine();
                    if (phonebook[i][j].isEmpty()) {
                        throw new EmptyEntryException("Please retry again.");
                    }
                } catch (EmptyEntryException e) {
                    System.out.println(e.getMessage());
                    j--;
                    continue;
                }
            }
            System.out.println("Here is your current row of data:");
            System.out.println();
            System.out.printf("%-30s", phonebook[i][0]);
            System.out.printf("%-30s", phonebook[i][1]);
            System.out.printf("%-30s", phonebook[i][2]);
            System.out.println("\nPress R and enter to retry the row of data.\nAny other key continue...");
            char choice = scanner.nextLine().charAt(0);
            if (choice == 'R') {
                System.out.println("Starting row over...");
                i--;
            }
        }

    }

    public static void printPhonebookData(String[][] phonebook) {

        // printing data to console
        System.out.println("\nPhoneBook App");
        System.out.printf("%-30s", "Name");
        System.out.printf("%-30s", "Phone");
        System.out.printf("%-30s", "City");
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%-30s", phonebook[i][j]);
            }
            System.out.println();
        }
    }

    private static void savePhonebookData(String[][] phonebook) throws FileNotFoundException {
        File file = new File("Phonebook.txt");

        PrintWriter out = new PrintWriter(file);
        // printing data to file, same as seen on the console
        out.println("\nPhoneBook App");
        out.printf("%-30s", "Name");
        out.printf("%-30s", "Phone");
        out.printf("%-30s", "City");
        out.println();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                out.printf("%-30s", phonebook[i][j]);
            }
            out.println();
        }
        out.close();
        System.out.println("\nPhonebook has been printed to file!");

    }
}