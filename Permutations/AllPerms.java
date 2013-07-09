public class AllPerms {
    public static void main(String[] args) {
	int[] arr = {1, 2, 3, 4};
	printAllPerms(arr);
    }

    private static void printAllPerms(int[] arr) {
	// call recursive method
	printAllPerms(arr, 0);
    }

    private static void printAllPerms(int[] arr, int index) {
	
	// base case for stopping recursion
	if (index == arr.length-1) {
	    for (int x : arr)
		System.out.print(x);
	    System.out.println();
	    return;
	}

	for (int i = index; i < arr.length; i++) {
	    
	    // swap
	    int t = arr[i];
	    arr[i] = arr[index];
	    arr[index] = t;

	    printAllPerms(arr, index + 1);
	    
	    // swap - back
	    t = arr[i];
	    arr[i] = arr[index];
	    arr[index] = t;
	}
    }
}
