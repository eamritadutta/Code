// When a problem like this is given as a white-board coding excercise, it is best to write 3 different test arrays for testing as inputs.

// e.g. 1 2 2 2 2 2 2 3 ----rotate---> 2 3 1 2 2 2 2 2  or 2 2 2 2 2 3 1 2

// e.g. 1 2 4 4 4 4 4 4 4 ---rotate---> 4 4 4 4 4 4 4 4 1 2 or 4 4 1 2 4 4 4 4 4    

// Use these test arrays to check the indices (st, end, mid) in each recursive call and make sure that various cases are handled appropriately

public class RotatedBinSearchWithDups {

    public static void main(String[] args) {

	System.out.println();

	int[] rotArr = {4, 5, 6, 7, 8, 1, 2, 3};
	int index = search(rotArr, 0, rotArr.length-1, 3);
	System.out.println("The element 3 in the array {4, 5, 6, 7, 8, 1, 2, 3} was found at: " + index);
	System.out.println();
	
	index = search(rotArr, 0, rotArr.length-1, 30);
	System.out.println("The element 30 in the array {4, 5, 6, 7, 8, 1, 2, 3} was found at: " + index);
	System.out.println();

	int[] rotArr2 = {4, 4, 4, 4, 4, 4, 4, 4, 1, 2, 3};
	index = search(rotArr2, 0, rotArr2.length-1, 2);
	System.out.println("The element 2 in the array  {4, 4, 4, 4, 4, 4, 4, 4, 1, 2, 3} was found at: " + index);
	System.out.println();
	
	System.out.println("The following test case demonstrates a quirk of this algorithm - if the searched entity viz. 'x' is present multiple times in the input array, this algorithm returns the first index where it encounters 'x', not necessarily the first or last index where 'x' is found in the input array");
	index = search(rotArr2, 0, rotArr2.length-1, 4);
	System.out.println();

	System.out.println("The element 4 in the array  {4, 4, 4, 4, 4, 4, 4, 4, 1, 2, 3} was found at: " + index);
	System.out.println();
    }

    // search returns -1 if 'x' is not found in the array
    public static int search(int[] arr, int st, int end, int x) {
	
	// when we know that 'x' has not been found in arr[ ]
	if (end < st) {
	    return -1;
	}

	// find mid and see if 'x' equals arr[mid] or not, if yes, we are done
	int mid = st + (end - st)/2;
	if (arr[mid] == x) 
	    return mid;

	// check arr[st] with arr[mid] to determine which direction to search 'x' in

	// e.g. 3 4 5 6 [7] 8 9 1 2 => left half (3, 4, 5, 6, 7) of input array, 'arr' is sorted in regular ascending order
	if (arr[mid] > arr[st]) {
	    if (x < arr[mid] && x >= arr[st]) { // Notice condition: x < arr[mid], and not x <= arr[mid], since if x == arr[mid] that would have already been handled
		return search(arr, st, mid-1, x);
	    }
	    else {
		return search(arr, mid+1, end, x);
	    }
	}
	
	// e.g. 8 9 1 2 [3] 4 5 6 7 => right half (3, 4, 5, 6, 7) of input array, 'arr' is sorted in regular ascending order
	else if (arr[mid] < arr[st]) {
	    if (x > arr[mid] && x <= arr[end]) { // Notice condition: x > arr[mid], and not x >= arr[mid], since if x == arr[mid] that would have already been handled
		return search(arr, mid+1, end, x);
	    }
	    else {
		return search(arr, st, mid-1, x);
	    }
	}

	else if (arr[mid] == arr[st]) {
	    // check arr[end], if arr[end] diff from arr[mid] and arr[st] then we will find 'x' in right
	    if (arr[end] != arr[mid]) {
		return search(arr, mid+1, end, x);
	    }
	    // we have no choice, but to scan for 'x' sequentially in both halves
	    else {
		int indexOfXInLeftHalf = search(arr, st, mid-1, x);
		if (indexOfXInLeftHalf != -1) { // found x on left half of array
		    return indexOfXInLeftHalf;
		}
		else {
		    return search(arr, mid+1, end, x);
		}
	    }
	}
	// technically, execution will never reach here.
	return -1;	    
    }
}
