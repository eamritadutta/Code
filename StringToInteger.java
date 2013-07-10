// Handle overflows for input integer (as String) less than Integer.MIN_VALUE;
// Handle overflows for input integer (as String) greater than Integer.MAX_VALUE;

// Input String can only contain digits (0 to 9) and signs '+' or '-'

// for all other cases, throw Exception

public class StringToInteger {
    
    public static void main(String[] args) {
	String input = "";
	int ret = 0;

	// Using multiple try - catch blocks ensures that the program continues despite Exceptions!
	try {
	    input = "123.45";
	    ret = testIfStringIsInteger(input);
	    System.out.println("The converted Integer is: " + ret);
	}
	catch (Exception e) {
	    System.out.println(e.getMessage());
	}

	try{
	    input = "1-23";
	    ret = testIfStringIsInteger(input);
	    System.out.println("The converted Integer is: " + ret);
	}
	catch (Exception e) {
	    System.out.println(e.getMessage());
	}
	
	try {
	    input = "-99";
	    ret = testIfStringIsInteger(input);
	    System.out.println("The converted Integer is: " + ret);
        }
	catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }

    private static int testIfStringIsInteger(String str) throws Exception {
	int i = 0;
	// to handle overflows
	long val = 0;
	boolean neg = false;

	if (str.charAt(0) == '+')
	    i++;
	else if (str.charAt(0) == '-') {
	    neg = true;
	    i++;
	}
	
	for (int j = i; i < str.length(); i++) {
	    int dig = str.charAt(i) - '0';
	    
	    if (dig >= 0 && dig <= 9) {
		val = (val * 10) + dig;

		// check for overflow
		if (val < Integer.MIN_VALUE || val > Integer.MAX_VALUE) {
		    throw new Exception("The string " + str + " cannot be converted to Integer.");
		}
	    }
	    else {
		throw new Exception("The string " + str + " cannot be converted to Integer.");
	    }
	}

	if (neg) 
	    val *= -1;

	return (int)val;
    }

    
}
