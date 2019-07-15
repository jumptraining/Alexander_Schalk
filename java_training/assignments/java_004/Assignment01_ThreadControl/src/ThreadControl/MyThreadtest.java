package ThreadControl;
// Suspending, resuming, and stopping a thread.
class MyThreadtest implements Runnable {
    Thread thread;
    boolean suspended;
    boolean stopped;
    
    //constructor
    MyThreadtest(String name) {
        thread = new Thread(this, name);
        suspended = false;
        stopped = false;
        thread.start();
    }
    // This is the entry point for thread.
    public void run() {
        System.out.println(thread.getName() + " is starting.");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.println("executing " + thread.getName());
                //10 second delay
                Thread.sleep(10000);

                // Use synchronized block to check suspended and stopped.
                synchronized(this) {
                    while (suspended) {
                        System.out.print(thread.getName() + " is suspended from running... ");
                        wait();
                    }
                    System.out.print(thread.getName() + " is still running... ");
                    if (stopped) {
                        break;
                    }
                }
            }
        } catch (InterruptedException exc) {
            System.out.println(thread.getName() + " is interrupted... ");
        }
        System.out.println(thread.getName() + " is exiting... ");
    }
    // Stop the thread.
    synchronized void mystop() {
        stopped = true;
        // The following ensures that a suspended thread can be stopped.
        suspended = false;
        notify();
    }
    // Suspend the thread.
    synchronized void mysuspend() {
        suspended = true;
    }
    // Resume the thread.
    synchronized void myresume() {
        suspended = false;
        notify();
    }
    // Set the priority (min, normal, max)
    public void setPriority(int i) {
        // TODO Auto-generated method stub
        thread.setPriority(i);
    }
}