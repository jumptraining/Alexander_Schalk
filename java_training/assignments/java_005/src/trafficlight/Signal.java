package trafficlight;

enum Signal {
	Green("GO", 5), Yellow("Beware", 2), Red("Stop", 3);

	String action; // words in ""
	private final int cycle; // timing of each light
	
	//Constructor
	Signal(String action, int cycle) { 
		this.action = action;
		this.cycle = cycle;
	}
	
	public int getTiming() {
		return cycle;
	}
	
	public String getAction() {
		return action;
	}
	
	//message repeats in a loop
	String getMessage() {
		String sigMess = "Light is " + name() + " - " + getAction() + "!";
		return sigMess;
	}
}