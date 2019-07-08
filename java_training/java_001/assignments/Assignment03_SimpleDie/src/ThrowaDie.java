import java.util.Scanner;

public class ThrowaDie {

	public static void main(String[] args) {
		
		System.out.println("Press any key to throw a die and press Enter (or Q and Enter to quit)");
		Scanner scan = new Scanner(System.in);
	    char choice = scan.next().charAt(0);
	    
		if(choice != 'Q') {
			//do-while loop for playing again
			do {
				//call RollDice method
				int num = RollDice();
				System.out.println("You have rolled a " + num); 
				System.out.println("Play Again? (Y or y) and Enter, any other key and Enter to Quit");
				choice = scan.next().charAt(0);
			} while(choice == 'Y' || choice == 'y');	
	}
}
	
	private static int RollDice() {
		// return random number 1-6
		return (int)(Math.random() * 6 + 1);
	}

}