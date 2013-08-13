public class MinInRotatedSorted {
    
    public static void main(String[] args) {
	test1();
	test2();
	test3();
	test4();
	test5();
	test6();
    }

    private static int getMinInRotatedSorted(int[] arr) throws Exception {
	if (arr == null || arr.length == 0) 
	    throw new Exception("Input array is empty or null");

	int mid = 0 + (arr.length -1) / 2;

	// array is sorted (in the default ascending order) but not rotated 
	if (arr[0] < arr[mid] && arr[mid] < arr[arr.length-1]) { // 1 2 3 4 5
	    throw new Exception("Input array is sorted (in the default ascending order) but not rotated.");
	}

	// array is not sorted (in the default ascending order), but in the descending order, which is not the norm
	else if (arr[0] > arr[mid] && arr[mid] > arr[arr.length-1]) { // 5 4 3 2 1 
	    throw new Exception("Input array is not sorted (in the default ascending order - but in the descending order), and not rotated.");
	}

	return getMinInRotatedSorted(arr, 0, arr.length-1);
    }
    
    private static int getMinInRotatedSorted(int[] arr, int st, int end) throws Exception {
	int mid = st + (end - st) /2;	
	
	if (mid != st && arr[mid] < arr[mid-1]) 
	    return arr[mid];

	else if (mid != end && arr[mid+1] < arr[mid])
	    return arr[mid+1];

	if (arr[mid] > arr[st])
	    return getMinInRotatedSorted(arr, mid, end);
	else
	    return getMinInRotatedSorted(arr, st, mid);
    }

    private static void test1() {
	int[] arr = {9, 11, 16, 20, 31, 42, 1, 3, 7, 8}; //  {90, 110, 1, 3, 7, 8, 9, 10, 20 30, 40};
	try {
	    int min = getMinInRotatedSorted(arr);
	    System.out.println("The min element is: " + min);
	}
	catch (Exception e) {
	    System.out.println(e.getMessage());
	    System.out.println("The input array does not comply with the restriction that the program operates on a rotated and soted array");
	}
	System.out.println();
    }

    private static void test2() {
	int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
	try {
	    int min = getMinInRotatedSorted(arr);
	    System.out.println("The min element is: " + min);
	}
	catch (Exception e) {
	    System.out.println(e.getMessage());
	    System.out.println("The input array does not comply with the restriction that the program operates on a rotated and soted array");
	}
	System.out.println();
    }

    private static void test3() {
	int[] arr = {7, 1, 2, 3, 4, 5, 6}; 
	try {
	    int min = getMinInRotatedSorted(arr);
	    System.out.println("The min element is: " + min);
	}
	catch (Exception e) {
	    System.out.println(e.getMessage());
	    System.out.println("The input array does not comply with the restriction that the program operates on a rotated and soted array");
	}
	System.out.println();
    }

    private static void test4() {
	int[] arr = {7, 8, 9, 10, 11, 12, 13, 4}; 
	try {
	    int min = getMinInRotatedSorted(arr);
	    System.out.println("The min element is: " + min);
	}
	catch (Exception e) {
	    System.out.println(e.getMessage());
	    System.out.println("The input array does not comply with the restriction that the program operates on a rotated and soted array");
	}
	System.out.println();
    }

    private static void test5() {
	int[] arr = {9, 11, 16, 20, 31, 42};
	try {
	    int min = getMinInRotatedSorted(arr);
	    System.out.println("The min element is: " + min);
	}
	catch (Exception e) {
	    System.out.println(e.getMessage());
	    System.out.println("The input array does not comply with the restriction that the program operates on a rotated and soted array");
	}
	System.out.println();
    }

     private static void test6() {
	 int[] arr = {13, 4, 7, 8, 9, 10, 11, 12}; 
	try {
	    int min = getMinInRotatedSorted(arr);
	    System.out.println("The min element is: " + min);
	}
	catch (Exception e) {
	    System.out.println(e.getMessage());
	    System.out.println("The input array does not comply with the restriction that the program operates on a rotated and soted array");
	}
	System.out.println();
    }
}
