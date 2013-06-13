import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class FileReading {
    private Scanner sc;

    public FileReading(String fileName) {
	    try {
	      sc = new Scanner(new File(fileName));
	    }
	    catch (Exception e) {
	      System.out.println("Could not open file");
	    }
    }

    public ArrayList<Integer> getNumbersFromFile() {
	    ArrayList<Integer> ints = new ArrayList<Integer>();
	    while (sc.hasNextInt()) {
	      ints.add(sc.nextInt());
	    }
	    return ints;
    }
}
