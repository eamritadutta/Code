public class CheckIfPositiveNumberIsPallindrome {
    public static void main(String[] args) {
	
	// test 3 numbers for pallindrome

	int num = 9119;
	boolean isPallindrome = checkIfPallindrome(num);
	printResult(num, isPallindrome);

	num = 91192;
	isPallindrome = checkIfPallindrome(num);
	printResult(num, isPallindrome);

	num = 91519;
	isPallindrome = checkIfPallindrome(num);
	printResult(num, isPallindrome);
    }

    private static void printResult(int num, boolean isPallindrome) {
	if (isPallindrome)
	    System.out.println("The number " + num + " is a pallindrome");
	else 
	    System.out.println("The number " + num + " is not a pallindrome");
    }

    private static boolean checkIfPallindrome(int num) {
	// generate the reverse of the input number 'num' and compare
	// reverse of 121 = 121

	int rev = 0;
	// num will change, hence save a copy to compare in the end
	int inputNum = num; 

	// start from right, to get the reversed number
	while (num > 0) {
	    rev = (rev * 10) + (num % 10);
	    num /= 10;
	}

	return (rev == inputNum) ? true : false;
    }
}
