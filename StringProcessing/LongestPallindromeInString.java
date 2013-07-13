// runs in O(n^2) time in the worst case - string is a single character repeated ! e.g. aaaaaaaaaaaaa
// runs in O(n) in the best case - string does not contain any pallindromic sub-sequence

import java.util.ArrayList;

public class LongestPallindromeInString {
    
    private static class Indices {
	int st;
	int end;

	public Indices(int st, int end) {
	    this.st = st;
	    this.end = end;
	}
    }

    public static void main(String[] args) {
	String str = "acgtgtcaaaatcgmadam";

	ArrayList<Indices> indices = getLongestPallindrome(str);
	if (indices != null) { 
	    for (Indices x : indices)
		System.out.println(str.substring(x.st, x.end+1));
	}
    }

    private static ArrayList<Indices> getLongestPallindrome(String str) {
	int p = 0;
 
	// even length
	if (str.length() % 2 == 0) {
	    p = 1;	    
	}

	int maxLen = Integer.MIN_VALUE;
	ArrayList<Indices> ret = new ArrayList<Indices>();

	for (int i = 0; i < str.length(); i++) {
	    int k = 0; 
	    
	    while (i+k+p < str.length() && i-k >= 0 && str.charAt(i+k+p) == str.charAt(i-k))
		k++;
		
	    if (k == maxLen) {
		k--;
		ret.add(new Indices(i-k, i+k+p));
	    }

	    else if (k > maxLen) {
		k--;
		ret = new ArrayList<Indices>();
		ret.add(new Indices(i-k, i+k+p));
		maxLen = k;
	    }
	}
	return ret;
    }
}
