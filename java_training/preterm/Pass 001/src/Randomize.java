import java.util.Random;

public class Randomize {
	/* Shuffles a 2D array with the same number of columns for each row. */
	public static void shuffle(String[][] matrix, int columns, Random rnd) {
	    int size = matrix.length * columns;
	    for (int i = size; i > 1; i--)
	        swap(matrix, columns, i - 1, rnd.nextInt(i));
	}

	/** 
	 * Swaps two entries in a 2D array, where i and j are 1-dimensional indexes, looking at the 
	 * array from left to right and top to bottom.
	 */
	public static void swap(String[][] matrix, int columns, int i, int j) {
	    String tmp = matrix[i / columns][i % columns];
	    matrix[i / columns][i % columns] = matrix[j / columns][j % columns];
	    matrix[j / columns][j % columns] = tmp;
	}
}