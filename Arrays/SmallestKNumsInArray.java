public class SmallestKNumsInArray {
    public static void main(String[] args) {
	int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
	
	// shuffling i/p array once is more than enough
	shuffle(arr);

	int[] ret = getKSmallest(arr, 3);
	System.out.println("The " + 3 + " smallest #s in the input array are: ");
	for (int i : ret) 
	    System.out.println(i);

	ret = getKSmallest(arr, 5);
	System.out.println("The " + 5 + " smallest #s in the input array are: ");
	for (int i : ret) 
	    System.out.println(i);
    }

    // shuffle the array
    private static void shuffle(int[] arr) {
	
	for (int i = 0; i < arr.length; i++) {
	    int piv = ((int) (Math.random() * (arr.length - i))) + i;
	    int t = arr[i];
	    arr[i] = arr[piv];
	    arr[piv] = t;
	}

	/*System.out.print("The shuffled array is: ");
	for (int x : arr) 
	    System.out.print(x + " ");

	    System.out.println();*/
    }

    private static int partition(int[] arr, int st, int end) {
	
	int i = st+1;
	int j = end;

	while ( i < j) {
	    while (i <= end && arr[i] < arr[st]) i++;

	    while (j > st && arr[j] > arr[st]) j--;

	    if (i < j) {
		 int t = arr[i];
		 arr[i] = arr[j];
		 arr[j] = t;
	    }
	}

	int t = arr[st];
	arr[st] = arr[j];
	arr[j] = t;
	
	return j;
    }

    // k starts from 1
    private static int[] getKSmallest(int[] arr, int k) {
	int[] ret = new int[k];
	
	// partition arr
	int piv = partition(arr, 0, arr.length - 1);

	System.out.println("j is: " + piv);
	while (piv != k-1) {
	    if (piv > k-1) {
		piv = partition(arr, 0, piv-1);
	    }
	    
	    else {
		piv = partition(arr, piv+1, arr.length-1);
	    }
	}

	for (int i = 0; i < k; i++) 
	    ret[i] = arr[i];

	return ret;
    }
}
