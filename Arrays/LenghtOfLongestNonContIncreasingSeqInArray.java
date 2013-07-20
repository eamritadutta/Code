public class LenghtOfLongestNonContIncreasingSeqInArray {
    
    public static void main(String[] args) {
	int[] arr = {4,2,6,1,7,9,8};
	int len = getLenOfLIS(arr);
	System.out.println("The length of the LIS for the given array is: " + len);
    }

    // searching for rank of 'x' in 'endVals'
    private static int binSearch(int[] endVals, int st, int end, int x) {
	
	while (st <= end) {
	    int mid = st + (end - st)/2;
	    if (x == endVals[mid]) {
		return mid;
	    }
	    
	    if (x < endVals[mid]) {
		return binSearch(endVals, st, mid-1, x);
	    }

	    if (x > endVals[mid]) {
		return binSearch(endVals, mid+1, end, x);
	    }
	}

	return st;
    }

    private static int getLenOfLIS(int[] arr) {
	// create a look up array
	int[] endValuesOfLIS = new int[arr.length];
	
	// number of active longest increasing sub-sequences whose ends we are tracking
	int count = 1;
	endValuesOfLIS[0] = arr[0];
	
	for (int i = 1; i < arr.length; i++) {
	    if (arr[i] < endValuesOfLIS[0]) {
		endValuesOfLIS[0] = arr[i];
	    }

	    else if (arr[i] > endValuesOfLIS[count -1]) {
		endValuesOfLIS[count ++] = arr[i];
	    }

	    else {
		int rank = binSearch(endValuesOfLIS, 0, count-1, arr[i]);
		endValuesOfLIS[rank] = arr[i];
	    }
	}

	// end of longest LIS is stored in the last element of 'endValuesOfLIS'
	return count;
    }
}
