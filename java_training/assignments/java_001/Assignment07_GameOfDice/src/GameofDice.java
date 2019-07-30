import java.util.Scanner;

public class GameofDice {

    public static void main(String[] args) {

        System.out.println("Welcome to the dice throw challenge!");
        System.out.println("Do you feel lucky? \"Punk\"... Do ya?");
        System.out.println("Press any key and ENTER to throw your dice or press (Q or q) to chicken your butt off...");
        Scanner scan = new Scanner(System.in);
        char choice = scan.next().charAt(0);
        
        // 7x7 2D matrix array 
    	// blank spaces not needed
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

        if (choice != 'Q' && choice != 'q') {
        	//while loop for playing again
            while (choice != 'Q' && choice != 'q') {
                
            	System.out.println("Rolling the dice!!");
                int[] num = new int[4];
                //call RollDicex4 method
                RollDicex4(num);

                System.out.println("You have rolled a " + num[0] + " and " + num[1] + " > the " + labels[num[0]][num[1]]);
                System.out.println("I have rolled a " + num[2] + " and " + num[3] + " > the " + labels[num[2]][num[3]]);
                
                //conditions statements handles all possible outcomes, tie or no tie, double or no double
                if (num[0] + num[1] == num[2] + num[3]) {
                    if (num[0] == num[1] && num[2] != num[3]) {
                        System.out.println("Damn! You win on a Double! What Luck!\nDid you cheat?? Gimme another try, c’mon. ");
                    } else if (num[0] != num[1] && num[2] == num[3]) {
                        System.out.println("Damn! I win on a Double! Ah! I pity you fool!\nWanna try again? ");
                    } else {
                        System.out.println("Stalemate! You’re tough, let’s try for a tie-breaker. ");
                    }
                } else if (num[0] + num[1] < num[2] + num[3]) {
                    System.out.println("I win!!!\nWanna try again? ");
                } else {
                    System.out.println("You win!!!\nDid you cheat?? Gimme another try, c’mon. ");
                }

                System.out.println("Press any key and ENTER to throw your dice or press (Q or q) to quit.");
                choice = scan.next().charAt(0);
            }
            System.out.println("Thanks for being a sport! Laters!");
        } else {
            System.out.println("See ya later alligator!");
        }
    }

    private static int[] RollDicex4(int[] num) {
        for (int i = 0; i < num.length; i++) {
            num[i] = (int)(Math.random() * 6 + 1);
        }
        return num;
    }
}