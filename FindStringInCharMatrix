public class FindStringInCharMatrix {
    public static void main(String[] args) {
	char[][] chars = {{'x', 'y', 'z'}, {'a', 'd', 'a'}, {'m', 'p', 'q'}};
	boolean found = findWord(chars, "adam");
	if (found) 
	    System.out.println("The string adam has been found in the matrix");
	else 
	    System.out.println("The string adam has not been found in the matrix");
	
	found = findWord(chars, "adams");
	if (found) 
	    System.out.println("The string adams has been found in the matrix");
	else 
	    System.out.println("The string adams has not been found in the matrix");
    }

    private static boolean findWord(char[][] chars, String str) {
	int rows = chars.length;
	// asssumning a non-skewed matrix
	int cols = chars[0].length;

	boolean[][] visited = new boolean[rows][cols];
	for (int i = 0; i < rows; i++) 
	    for (int j = 0; j < cols; j++) {
		boolean found = match(chars, i, j, str, 0, visited);
		if (found) 
		    return found;
	    }
	
	return false;
    }

    private static boolean match(char[][] chars, int r, int c, String str, int index, boolean[][] visited) {
	if (str.length() == index) 
	    return true;

	if (r < 0 || r >= chars.length || c < 0 || c >= chars[0].length)
	    return false;

	if (visited[r][c] == true || str.charAt(index) != chars[r][c]) 
	    return false;

	// mark cell
	visited[r][c] = true;

	boolean matched = match(chars, r+1, c, str, index+1, visited) || match(chars, r-1, c, str, index+1, visited) || match(chars, r, c+1, str, index+1, visited) || match(chars, r, c-1, str, index+1, visited);

	if (matched) 
	    return matched;

	// un-mark cell
	visited[r][c] = false;
	
	return matched;
    }
}
