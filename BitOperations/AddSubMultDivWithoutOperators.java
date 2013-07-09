public class AddSubMultDivWithoutOperators {

    public static void main(String[] args) {
	    int num1 = 8;
	    int num2 = 8;

	    int res = addWithoutOp(num1, num2);
	    System.out.println("The addition result is: " + sum);

	    res = subWithoutOp(num1, num2);
    }

    public static int addWithoutOp(int num1, int num2) {
	    int sum;
	    int carry;
	
    	do {
	      sum = num1 ^ num2;
	      carry = (num1 & num2) << 1;

	      num1 = sum; 
	      num2 = carry;

	    } while (num2 > 0);

	    return num1;
    }    
}
