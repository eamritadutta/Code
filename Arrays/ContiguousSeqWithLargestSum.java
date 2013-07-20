// This class finds the longest continuous array elements with the largest sum

// This solution finds the largest cont sub seq with max sum even if the array contains all -ve elements. 
// In this case, the program returns min -ve element.

public class ContiguousSeqWithLargestSum {
    
    public static void main(String[] args) {
	int[] arr1 = {2, 3, -8, -1, 2, 4, -2, 3};
	printLargestContSubSeq(arr1);

	int[] arr2 = {-20, -3, -8, -1, -12, -4, -25, -31};
	printLargestContSubSeq(arr2);
    }

    private static void printLargestContSubSeq(int[] arr) {
	int maxSum = arr[0];
	int sum = arr[0];
	
	for (int i = 1; i < arr.length; i++) {
	    sum += arr[i];
	    
	    if (sum > maxSum) {
		maxSum = sum;
	    } 

	    if (sum <= 0) {
		sum = 0;
	    }
	}

	System.out.println("The sum of the elements forming the largest contiguous sum is: " + maxSum);
    }
}
