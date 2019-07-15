package trafficlight;

import java.util.Scanner;

public class MainApp {
	//main method
    public static void main(String args[]) {
        
    	//initialize thread array
    	//only one thread seems to be necessary for this assignment
        ThreeThreads test[] = new ThreeThreads[1];
        for (int i = 0; i < test.length; i++) {
            test[i] = new ThreeThreads("Thread " + (i + 1));
            //test[i].run();
            //System.out.println(test[i] + " has started");
        }

    	Scanner scan = new Scanner(System.in);

    	//determines if user hits enter without any input
    	if(scan.nextLine().isEmpty()) {
        	for (int i = 0; i < test.length; i++) {
        		test[i].mystop();
         	}
        }
    }
}