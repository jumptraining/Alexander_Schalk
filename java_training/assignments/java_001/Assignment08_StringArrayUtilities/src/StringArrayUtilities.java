public class StringArrayUtilities {

    public static void main(String[] args) {

        System.out.println("This is a test of the arrayHasExactMatch and indexOfOccurenceInArray methods.\nThe array to test contains the following items:");
        System.out.println("{\"Bozo\", \"FooBar\", \"Delta\", \"Foozball\", \"Demo\", \"Money\", \"Zoo\"}");
        // create a bunch of strings and arrays to print repetitive stuff in the for loop
        String myList[] = new String[] {
            "Bozo",
            "FooBar",
            "Delta",
            "Foozball",
            "Demo",
            "Money",
            "Zoo"
        };
        String firstMethod = "arrayHasExactMatch";
        String secondMethod = "indexOfOccuranceInArray";
        String before = " (myList, \"";
        String[] after = new String[] {
            "\", false)",
            "\", false)",
            "\", true)",
            "\", true)",
            "\", false)",
            "\", true)",
            "\", true)"
        };
        String[] tests = new String[] {
            "zo",
            "zoo",
            "zoo",
            "foo",
            "foo",
            "delta",
            "Delta"
        };
        Boolean[] sensitive = new Boolean[] {
            false,
            false,
            true,
            true,
            false,
            true,
            true
        };
        for (int i = 1; i <= 14; i++) {
            System.out.println("Scenario " + i);
            System.out.print(i <= 7 ? firstMethod : secondMethod);
            System.out.print(before + tests[i <= 7 ? i - 1 : i - 8] + after[i <= 7 ? i - 1 : i - 8]);
            // call either method depending on the scenario number
            System.out.print(i <= 7 ? " is " + arrayHasExactMatch(myList, tests[i - 1], sensitive[i - 1]) : " returns [" + indexOfOccuranceInArray(myList, tests[i - 8], sensitive[i - 8]) + "]");
            System.out.print("\n");
        }
    }

    static boolean arrayHasExactMatch(String myList[], String tests, boolean sensitive) {
        boolean found = false;
        
        // for loop goes through the array
        for (int i = 0; i < myList.length; i++) {
            if (sensitive == true) {
                found = (myList[i].equals(tests) ? true : false);
                // System.out.print("\n" + myList[i] + " equals " + tests + " ? " + found);

            } else {
                found = (myList[i].equalsIgnoreCase(tests) ? true : false);
                // System.out.print("\n" + myList[i] + " equalsIgnoreCase " + tests + " ? " + found);
            }
            // end for loop and method if string matches
            if (found == true) {
                return found;
            }
        }
        return found;
    }

	//there is only one index to be found so I'm return a non-array
    static int indexOfOccuranceInArray(String myList[], String tests, boolean sensitive) {
        int foundIndex = -1;
        
        // for loop goes through the array
        for (int i = 0; i < myList.length; i++) {
            if (sensitive == true) {
                foundIndex = (myList[i].equals(tests) ? i : -1);
                // System.out.print("\n" + myList[i] + " equals " + tests + " ? " + foundIndex);

            } else {
                foundIndex = (myList[i].equalsIgnoreCase(tests) ? i : -1);
                // System.out.print("\n" + myList[i] + " equalsIgnoreCase " + tests + " ? " + foundIndex);
            }
            
            // end for loop and method if string matches
            if (foundIndex != -1) {
                return foundIndex;
            }
        }
        return foundIndex;
    }
}