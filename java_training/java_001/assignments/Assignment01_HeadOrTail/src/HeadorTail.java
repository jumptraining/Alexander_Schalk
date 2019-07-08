public class HeadorTail {

	public static void main(String[] args) {
		// call CoinFlip method
		int coin = CoinFlip();
		
		System.out.println("Coin Flip Program");
		// 1 means Head, 2 means Tail
		System.out.println("This Coin Flip is: " + (coin == 1? "Head" : "Tail"));
	}

	private static int CoinFlip() {
		// return either 1 or 2
		return (int)(Math.random() * 2);
	}
}