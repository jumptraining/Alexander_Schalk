package matrixchoice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintTheMatrix {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Select one of the follow options:\nPress 1 and hit Enter to print on screen only\nPress 2 and hit Enter to print on file only\nPress 3 and hit Enter to print on both");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        // 7x7 2D matrix array 
        // blank spaces are added to space things out evenly
        // since tabs aren't helpful enough
        String[][] labels = {
            {
                "",
                "Die 1",
                "Die 2",
                "Die 3",
                "Die 4",
                "Die 5",
                "Die 6"
            },
            {
                "Die 1",
                "Snake eyes",
                "Australian yo",
                "Little Joe From Kokomo",
                "No field five",
                "Easy six",
                "Six one you're done"
            },
            {
                "Die 2",
                "Ace caught a deuce",
                "Ballerina",
                "The fever",
                "Jimmie Hicks",
                "Benny Blue",
                "Easy eight"
            },
            {
                "Die 3",
                "Easy four",
                "OJ",
                "Brooklyn Forest",
                "Big Red",
                "Eighter from Decatur",
                "Nina from Pasadena"
            },
            {
                "Die 4",
                "Little Phoebe",
                "Easy six",
                "Skinny McKinney",
                "Square pair",
                "Railroad nine",
                "Big one on the end"
            },
            {
                "Die 5",
                "Sixie from Dixie",
                "Skinny Dugan",
                "Easy eight",
                "Jesse James",
                "Puppy Paws",
                "Yo"
            },
            {
                "Die 6",
                "The Devil",
                "Easy eight",
                "Lou Brown",
                "Tennessee",
                "Six five no jive",
                "Midnight"
            }
        };

        if (choice == 1 || choice == 3) {
            System.out.println("Dice Combinations Label Matrix");
            //nested for loop displays matrix
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.printf("%-25s", labels[i][j]);
                }
                System.out.println();
            }
        }
        if (choice == 2 || choice == 3) {

            File file = new File("Matrix.txt");

            PrintWriter out = new PrintWriter(file);

            out.println("Dice Combinations Label Matrix");
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    out.printf("%-25s", labels[i][j]);
                }
                out.println();
            }
            out.close();
            System.out.println("Matrix has been printed to file!");
        }
    }

}