package ThreadControl;
import java.io.IOException;
import java.util.Scanner;
//TestingThreadControls.java and MyThreadtest.java are used for this program

public class TestingApp extends Thread {

    public static void main(String args[]) throws IOException, InterruptedException {
        // creating 5 objects of MyThreadtest 
        //eg MyThreadtest t1 = new MyThreadtest("thread 1");
        MyThreadtest[] threads = new MyThreadtest[5];

        //initialize the thread names
        for (int i = 0; i < 5; i++) {
            threads[i] = new MyThreadtest("Thread " + (i + 1));
            Thread.sleep(500);
        }

        //values are false by default
        boolean[] terminated = new boolean[5];

        while (allTrue(terminated) == false) {
            try {
                Scanner scan = new Scanner(System.in);

                int choice = scan.nextInt();

                if (0 < choice && choice < 6) {
                	ControlMethod.Control(threads[choice - 1], choice, terminated, scan);
                }

                //scan.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        //program may not end immediately when this line is displayed
        System.out.println("This app is exiting, all threads have been stopped.");
    } // end of main method

    // method with end while loop in main method if it returns true
    public static boolean allTrue(boolean[] terminated) {
        for (boolean b: terminated) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}