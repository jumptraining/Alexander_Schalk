package arrayutils;

public class ArrUtil {

	protected static boolean arrayHasExactMatch(String myList[], String tests, boolean sensitive) {
		boolean found = false;	
		
        // for loop goes through the array
		for(int i = 0; i < myList.length; i++) {
			if(sensitive == true) {
				found = (myList[i].equals(tests)? true : false);
				//System.out.print("\n" + myList[i] + " equals " + tests + " ? " + found);
				
			} else {
				found = (myList[i].equalsIgnoreCase(tests)? true : false);
				//System.out.print("\n" + myList[i] + " equalsIgnoreCase " + tests + " ? " + found);
			}
            // end for loop and method if string matches
			if(found == true) {
				return found;
			}
		}
		return found;
	}

	//there is only one index to be found so I'm return a non-array
	protected static int indexOfOccuranceInArray(String myList[], String tests, boolean sensitive) {
		int foundIndex = -1;
		
        // for loop goes through the array
		for(int i = 0; i < myList.length; i++) {
			if(sensitive == true) {
				foundIndex = (myList[i].equals(tests)? i : -1);
				//System.out.print("\n" + myList[i] + " equals " + tests + " ? " + found);
				
			} else {
				foundIndex = (myList[i].equalsIgnoreCase(tests)? i : -1);
				//System.out.print("\n" + myList[i] + " equalsIgnoreCase " + tests + " ? " + found);
			}
            // end for loop and method if string matches
			if(foundIndex != -1) {
				return foundIndex;
			}
		}
		return foundIndex;
	}
}