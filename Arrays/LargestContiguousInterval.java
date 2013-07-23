/*
Given a list of integers, find out the biggest interval that has all its members in the given list. 
e.g. given list 1, 7, 4, 6, 3, 10, 2 then answer would be [1, 4]. Develop algorithm and write code for this.
*/

import java.util.BitSet;

public class LargestContiguousInterval {
    
    public static void main(String[] args) {
  	int[] arr = {1, 7, 4, 6, 3, 10, 2};

	printLargestContInterval(arr);
    }

    private static void printLargestContInterval(int[] arr) {
	BitSet bits = new BitSet();
	
	for (int i = 0; i < arr.length; i++) {
	    bits.set(arr[i]);
	}

	// scan through the bit set
	int len = bits.length();
	int count = 0;
	int maxCount = Integer.MIN_VALUE;
	int maxStart = -1;
	int start = -1;

	for (int i = 0; i<len; i++) {
	    if (bits.get(i)) {
		count++;
		if (start == -1) 
		    start = i;
	    } else {
		
		if (count > maxCount) {
		    maxCount = count;
		    maxStart = start;
		    
		}

		start = -1;
		count = 0;
	    }
	}

	// print the max cont range in 'arr'
	System.out.println("[" +  maxStart + " - " + (maxStart+maxCount-1) + "]");	
    }
}
