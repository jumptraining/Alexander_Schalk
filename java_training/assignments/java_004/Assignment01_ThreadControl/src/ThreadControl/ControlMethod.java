package ThreadControl;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlMethod {

    static void Control(MyThreadtest t, int choice, boolean[] terminated, Scanner scan) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        int repeat = -1;
        
        //boolean flags used to control which lines of code can be executed
        boolean Running = true;
        boolean Execute = true;
        boolean Pause = false;
        boolean Resume = false;
        boolean showControl = true;
        
        //check if thread has been stopped first
        if (terminated[choice - 1] == true) {
            System.out.println("Thread " + choice + " has been stopped and cannot be controlled.");
        } else {
            while (Running == true) {

                char key = 1;
                if (showControl) {
                    if (Execute == true) {
                        System.out.println("Controlling thread " + choice);
                        Execute = false;
                        Pause = true;
                    } else if (Pause == true && repeat == choice) {
                        System.out.println("Pausing thread " + choice);
                        t.mysuspend(); //call method in MyThreadtest
                        Pause = false;
                        Resume = true;
                    } else if (Resume == true && repeat == choice) {
                        System.out.println("Resuming thread " + choice);
                        t.myresume(); //call method in MyThreadtest
                        Resume = false;
                        Execute = true;
                    }
                }

                //if input is a char then key = scan.next().charAt(0); 
                //else if input is an int then repeat = scan.nextInt();
                // showControl enables either the if else if blocks of code
                // or the Switch statements below, depending on input
                try {
                    repeat = scan.nextInt();
                    showControl = true;
                } catch (InputMismatchException e) {
                    key = scan.next().charAt(0);
                    showControl = false;
                }

                switch (key) {
                    case 'T':
                        t.setPriority(10); //call method in MyThreadtest
                        System.out.println("Thread " + choice + " was set to max priority.");
                        break;
                    case 'L':
                        t.setPriority(1); //call method in MyThreadtest
                        System.out.println("Thread " + choice + " was set to min priority.");
                        break;
                    case 'N':
                        t.setPriority(5); //call method in MyThreadtest
                        System.out.println("Thread " + choice + " was set to normal priority.");
                        break;
                    case 'S':
                        t.mystop(); //call method in MyThreadtest
                        Running = false; //ends while loop
                        terminated[choice - 1] = true; //prevents further control of thread
                        System.out.println("Permanently stopping the execution of Thread " + choice);
                        System.out.println("Available threads are: " + Thread.getAllStackTraces().keySet());
                        break;
                }
            }
        }
    }
}
