/*
To check if an input string contains duplicates we can do the following:

Solution 1: Use two loops to check for duplicates. Complexity: O(n^2)

Solution 2: We can use hash the characters and check if an element already exists. Complexity: O(n); Space complexity: O(256 characters)

Solution 3: Use a 32-bit int. This process is shown below. Time Complexity (worst case): O(n); Space complexity: O(1) 
*/

public class CheckDupCharsInString {

    public static void main(String[] args) {
	String str = "plantiff";
	boolean hasDups = checkForDups(str);
	System.out.println("The string " + str + " has duplicates is: " + hasDups);

	str = "plantif";
	hasDups = checkForDups(str);
	System.out.println("The string " + str + " has duplicates is: " + hasDups);
    }

    private static boolean checkForDups(String str) {
	
	int bitCheck = 0;
	for (int i = 0; i < str.length(); i++) {
	    
	    // b/w 0 and 25
	    int intValOfChar = str.charAt(i) - 'a'; // for c, index = 2
	    
	    // b/w 2^0(=1) and 2^25
	    // this is possible since, the maximum value an int can have is (2^31)-1.
	    int bitIndexInBitCheck = 1 << intValOfChar;

	    if ((bitCheck & bitIndexInBitCheck) > 0) {
		// found duplicate char in string
		return true;
	    }
	    
	    bitCheck |= bitIndexInBitCheck;
	}

	// no char in 'str' is duplicated ! 
	return false;
    }
}
