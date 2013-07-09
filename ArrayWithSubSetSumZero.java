import java.util.BitSet;

public class ArrayWithSubSetSumZero {
    
    // # of sub sets of input array - for debug outupt
    private static int count = 0; 

    public static void main(String[] args) {
	int[] arr = {1, 10, 4, 3, -4, 5, 3, 2, -10};

	printAllSubSetsWithZeroSum(arr);
    }

    private static void printAllSubSetsWithZeroSum(int[] arr) {
	BitSet bits = new BitSet(arr.length);

	while (canIncrBits(bits, arr.length-1)) {
	    count ++;
	    checkSubSetSumAndPrintIfSumIsZero(arr, bits);
	}
    }

    private static boolean canIncrBits(BitSet bits, int len) {
	boolean ret = true;

	while (len >= 0 && bits.get(len)) {
	    bits.flip(len);
	    len --;
	}

	if (len == -1) 
	    ret = false;

	else {
	    bits.flip(len);
	}

	return ret;
    }

    private static void checkSubSetSumAndPrintIfSumIsZero(int[] arr, BitSet bits) {
	int sum = 0;
	boolean oneSetBit = false;
	
	// debug output
	// System.out.println("For combination number: " + count);
	
	for (int i = 0; i < arr.length; i++) {
	    if (bits.get(i)) {
		sum += arr[i];
		if (!oneSetBit) 
		    oneSetBit = true;
	    }
	}
	
	if (oneSetBit && sum == 0) {
	    System.out.println("One sub set of input array with sum = 0 is: ");
	    
	    for (int i = 0; i < arr.length; i++) {
		if (bits.get(i)) {
		    System.out.print(arr[i] + " ");
		}
	    }

	    System.out.println();
	}
	else {
	    // debug output
	    // System.out.println("Found one sub set of input array not having sum = 0");
	}
    }
}
