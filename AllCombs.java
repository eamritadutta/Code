import java.util.BitSet;

public class AllCombs {
    public static void main(String[] args) {
		String str = "xyzq";
	
		// call the master function for combinations
		printCombs(str);
    }

    public static void printCombs(String str) {
	
		// start from right and move left
		int index = str.length()-1;
	
		// create the BitSet
		BitSet bits = new BitSet(str.length());

		// keep incrementing the bit set till we reach index == 0
		while (increment(bits, index)) {
	    	print(bits, str);
		}
    }

    // finds the rightmost 0 bit and flips it (changing it to 1)
    // sets the next bit to 1
    public static boolean increment(BitSet bits, int index) {
		while(index >= 0 && bits.get(index)) {
	    	bits.set(index, false); 
	    	index --;
		}
		// we did not find a single '0' in the entire bit set 
		// implies we have reached '111' as in 
		// got all possible combinations of the str ! we should stop now ! 
		if (index < 0) {
	    	return false;
		}
	
		// the momnet we come out of the while loop 
		// set that bit to 1
		bits.set(index);
		return true;
    }

    public static void print(BitSet bits, String str) {
		// for each char in 'str' 
		// check the corr. bit in BitSet
		for (int i = 0; i < str.length(); i++) {
	    	if (bits.get(i))
			System.out.print(str.charAt(i));
		}
		System.out.println();
    }
}
