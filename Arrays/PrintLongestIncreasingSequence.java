public class PrintLongestIncreasingSequence {
    
    // for testing
    public static void main(String[] args) {
	int[] arr1 = {1, 0, 1, 2, 3, 0, 4, 5};
	printLongestIncreasingSequence(arr1);
	int[] arr2 = {1, 1, 1, 0, 0, 2, 3, 4, 4, 4, 4};
	printLongestIncreasingSequence(arr2);
    }

    private static void printLongestIncreasingSequence(int[] arr) {
	if (arr == null || arr.length == 0) 
	    return;

	int[] tailIndices = new int[arr.length];
	tailIndices[0] = 0;
	
	// for reconstruction
	int[] prevTailIndices = new int[arr.length];
	for (int k = 0; k < prevTailIndices.length; k++)
	    prevTailIndices[k] = -1;

	// len keeps track of the length of LIS seen so far
	int len = 1;

	for (int i = 1; i < arr.length; i++) {
	    if (arr[i] < arr[tailIndices[0]]) {
		// new active list
		tailIndices[0] = i;
	    }

	    else if (arr[i] > arr[tailIndices[len-1]]) {
		// extend the exisiting longest active list
		prevTailIndices[i] = tailIndices[len-1];
		tailIndices[len++] = i;
	    }

	    else {
		// over-write some element of existing active list with an element of smaller value
		int rank = binSearch(arr, tailIndices, 0, len-1, arr[i]);
		if (rank > 0)
		    prevTailIndices[i] = tailIndices[rank-1];
		tailIndices[rank] = i;
	    }
	}

	if (len >= 2) {
	    // reconstruct
	    Stack<Integer> st = new Stack<Integer>();
	    for (int j = tailIndices[len-1]; j>=0; j = prevTailIndices[j]) {
		st.push(arr[j]);
	    }
	    System.out.println(st);
	}
    }

    private static int binSearch(int[] arr, int[] tailIndices, int st, int end, int key) {
	while (st <= end) {
	    int mid = st + (end - st)/2;
	    if (arr[tailIndices[mid]] == key) 
		return mid;

	    if (arr[tailIndices[mid]] < key) 
		end = mid - 1;

	    else 
		st = mid + 1;
	}
	return st;
    }    
}
