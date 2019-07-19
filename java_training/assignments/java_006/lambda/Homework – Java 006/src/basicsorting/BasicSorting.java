package basicsorting;

import java.util.Arrays;
import java.util.Collections;

public class BasicSorting {

	public static void main(String[] args) {
		
		//lambda for number array sorting, ascending and descending
		IntSort<?> firstLambda = (int numArr[], String direction) -> {
			
			Arrays.sort(numArr);
			if(direction.equals("ASC")) {
				//System.out.println(numArr.toString());
	        	return Arrays.toString(numArr);
	        } else {
	        	/*function swaps the array's first element with last element,  
	            second element with last second element and so on*/
	        	int i, t, n = numArr.length; 
	            for (i = 0; i < n / 2; i++) { 
	                t = numArr[i]; 
	                numArr[i] = numArr[n-i-1]; 
	                numArr[n-i-1] = t; 
	            } 
	        	return Arrays.toString(numArr);	
	        }
		};	
		
		//lambda for string array sorting, ascending and descending
		//case sensitive and case insensitive
		StringSort<?> secondLambda = (String strArr[], String direction, String caps) -> {
						
			if(direction.equals("ASC")) {
				if(caps.equals("ON")) {
					Arrays.sort(strArr);
				} else if(caps.equals("OFF")) {
					Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
				}
					return Arrays.toString(strArr);
					
			} else if(direction.equals("DESC")){
				if(caps.equals("ON")) {
					Arrays.sort(strArr, Collections.reverseOrder());
				} else if(caps.equals("OFF")) {	
					Arrays.sort(strArr, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
				}
	        		return Arrays.toString(strArr);
			}
			return "ERROR";
		};
		
		// declare arrays and strings
		int[] numArr = { 10, 3, 4, 15, 7, 9, 1, 21 };
		String[] strArr = { "claude", "Phil", "lois", "clark", "Arthur", "Mera", "bruce" };
		String direction1 = "ASC", direction2 = "DESC";
		String caps1 = "ON", caps2 = "OFF";
		//firstLambda.sort(numArr, "ASC");
		
		//print out information, call lambdas for all cases
		System.out.println("Initial Integer Array: { 10, 3, 4, 15, 7, 9, 1, 21 }");
		System.out.println("Sorted " + direction1 + ": " + firstLambda.sort(numArr, direction1));
		System.out.println("Sorted " + direction2 + ": " + firstLambda.sort(numArr, direction2));
		System.out.println("Initial String Array: { \"claude\", \"Phil\", \"lois\", \"clark\", \"Arthur\", \"Mera\", \"bruce\" }");
		System.out.println("Sorted " + direction1 + " and CASE SENSITIVITY " + caps1 + ": " + secondLambda.sort(strArr, direction1, caps1));
		System.out.println("Sorted " + direction1 + " and CASE SENSITIVITY " + caps2 + ": " + secondLambda.sort(strArr, direction1, caps2));
		System.out.println("Sorted " + direction2 + " and CASE SENSITIVITY " + caps1 + ": " + secondLambda.sort(strArr, direction2, caps1));
		System.out.println("Sorted " + direction2 + " and CASE SENSITIVITY " + caps2 + ": " + secondLambda.sort(strArr, direction2, caps2));
	}
}