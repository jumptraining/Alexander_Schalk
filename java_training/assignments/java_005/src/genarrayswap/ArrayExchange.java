package genarrayswap;

public class ArrayExchange {

	//  exchange the positions of two different elements in an array
    public static final < T > void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    //main method
    public static void main(String[] args) {

    	//String array with 2 elements
        String[] myList = {
            "First",
            "Second",
        };
        
        System.out.println("Original List: \n" + myList[0] + " " + myList[1]);
        //call swap method
        swap(myList, 0, 1);
        System.out.println("New List: \n" + myList[0] + " " + myList[1]);

    }
}