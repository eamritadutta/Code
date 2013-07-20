// This class finds the longest continuous array elements with the largest sum

public class ContiguousSeqWithLargestSum {
    
    public static void main(String[] args) {
  	int[] arr = {2, 3, -8, -1, 2, 4, -2, 3};
	
	printLargestContSubSeq(arr);
    }

    // this solution assumes that 'arr' will have both +ve and -ve elements
    private static void printLargestContSubSeq(int[] arr) {
	int maxSum = arr[0];
	int sum = arr[0];
	int st = 0; 
	int end = 0;

	for (int i = 1; i < arr.length; i++) {
	    sum += arr[i];
	    
	    if (sum <= 0) {
		st = i+1;
		sum = 0;
		continue;
	    }

	    if (sum > maxSum) {
		maxSum = sum;
		end = i;
	    } 
	}

	System.out.println("The sum of the elements forming the largest contiguous sum is: " + maxSum);
    }
}
