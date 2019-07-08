
public class KeepingWayMoreStats {

	public static void main(String[] args) {
		
		int face1 = 1, face2 = 1, count = 0;		
		// there are 21 unique combos
		int[] combos = new int[21];
		// call RollDice method
		RollDice(combos);
		System.out.println("1000 Random 2 dice toss stats");
		
		// for loop displays all dice combos
		for(int i = 0; i < 21; i++) {
			System.out.println("Dice " + face1 + " and " + face2 + ": " + combos[i] + " times");
			face2++;
			if(face2 == 7) {
				face1++;
				face2 = face1;
			}
		}
	}	
		
		private static int[] RollDice(int[] combos) {
			// not sure why high and low iterations are necessary
			// instead randomly incrementing 21 possible outcomes
			for (int i = 0; i < 1000; i++) {
				combos[(int)(Math.random() * 21)]++;
			}
			return combos;
		}
}