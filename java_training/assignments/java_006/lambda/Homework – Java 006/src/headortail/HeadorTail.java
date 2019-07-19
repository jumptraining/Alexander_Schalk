package headortail;

import java.util.Scanner;

public class HeadorTail {

	public static void main(String[] args) {

		//lambda returns 1 or 2
		MyFlip firstLambda = () -> {
			// using Math.random()
			int value = (int)(Math.random() * 2 + 1);
			return value;
		};
		
		//lambda returns Head or Tail
		Coin secondLambda = (value) -> {
			String face = value == 1? "Head" : "Tail";
			return face;
		};

		// messages to be printed out in loop
		String INIT = "Welcome to the game of Head or Tail where you will flip your life away!";
		String FIRSTPASS = "Press the F key and flip your luck!";
		String CONDITIONALOUTPUT = "The coin flip is: ";
		String ENDORCONTINUE = "Press the F key to try again, press Q or q to Quit";
		String EXIT = "Thank you for playing";

		System.out.println(INIT + "\n" + FIRSTPASS);

		Scanner scan = new Scanner(System.in);
		char choice = scan.next().charAt(0);	

		while(choice != 'Q' && choice != 'q') {
			if(choice == 'F') {
				//secondLambda depends on outcome of firstLambda
				System.out.println(CONDITIONALOUTPUT + secondLambda.face(firstLambda.flip()) + "\n" + ENDORCONTINUE);
			}
			choice = scan.next().charAt(0);
		}
			System.out.println(EXIT);
			scan.close();
	}
}