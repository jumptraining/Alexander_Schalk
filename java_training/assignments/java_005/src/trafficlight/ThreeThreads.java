package trafficlight;

class ThreeThreads extends Thread {
    //static int sum;
    Signal signal;
    boolean stopped;
    Thread thread;

    //thread constructor
    ThreeThreads(String name) {
        thread = new Thread(this, name);
        stopped = false;
        thread.start();
    }

    public void run() {
        System.out.println("Traffic Light Simulator is a Go!");
        while (stopped == false) {
            try {
                for (Signal signal: Signal.values()) {
                    //System.out.println("Light is " + signal.name() + " - " + signal.getAction() +"!");
                    System.out.println(signal.getMessage());
                    //System.out.println(signal.getTiming() + " second delay");
                    Thread.sleep(1000 * signal.getTiming());

                    // Use synchronized block
                    synchronized(this) {
                        if (stopped) {
                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //when user presses enter
    synchronized void mystop() {
        stopped = true;
        notify();
    	System.out.println("Traffic Light Simulator is Done!");
    }
}