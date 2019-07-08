public class KeepingStats {

	public static void main(String[] args) {
		// array for both Head and Tail
		int[] tally = new int[]{0, 0};
		
		// call CoinFlip method
		CoinFlip(tally);
		
		System.out.println("1000 Coin Flips");
		System.out.println("Count of Head: " + tally[0]);
		System.out.println("Count of Tail: " + tally[1]);
	}

	private static int[] CoinFlip(int[] tally) {
		// 1000 randomized increments in the array
		for (int i = 0; i < 1000; i++) {
			if((int)(Math.random() * 2) == 1) {
				tally[0]++;
			} else {
				tally[1]++;
			}
		}
		return tally;
	}
}