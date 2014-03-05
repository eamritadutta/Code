public class Boggle {

    private static boolean findMatch(char[][] arr, int dim, String word) {
        // basic checks                                                                           
        if (arr == null || dim <= 0 || word == null || word.length() == 0) {
            return false;
        }

        // create a new 2D array to mark the used up words in the input array                     
        // boolean arrays are initialized to false in java                                        
        boolean[][] used = new boolean[dim][dim];

        boolean matched = false;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                // match first char of 'word' with any of the cells in the input grid             
                matched = matchChars(arr, dim, i, j, word, 0, used);
                if (matched) {
                	return matched;
               	}
            }
	}
        // matched will always be false if we reach here !                                        
        return matched;
    }

    private static boolean matchChars(char[][] arr, int dim, int i, int j, String word, int index, boolean[][] used) {
        if (index == word.length()) {
            return true;
        }

        // boundary check on 'arr'                                                                
        if (i < 0 || j < 0 || i == dim || j == dim) {
            return false;
        }

        if (word.charAt(index) != arr[i][j]) {
            return false;
        }
        if (used[i][j] == true) {
            return false;
        }

        used[i][j] = true;

        // create traversal array for better code readability - Twitter baked idea !              
        int[][] tr = {{-1, 0, 1, 0}, {0, 1, 0, -1}};
        for (int k = 0; k < 4; k++) {

            // char from grid has not been used                                                   
            boolean ret = matchChars(arr, dim, i+tr[0][k], j+tr[1][k], word, index+1, used);
            if (ret == true) {
                return true;
            }

        }

        used[i][j] = false;
        return false;
    }

public static void main(String[] args) {
        char[][] arr = {{'x', 'x', 'x'}, {'b', 'a', 'd'}, {'x', 'x', 'x'}};
        boolean found = findMatch(arr, 3, "bad");
        if (found) {
            System.out.println("The word bad was found in the input array");
        } else {
            System.out.println("The word bad was not found in the input array");
        }
        char[][] arr2 = {{'x', 'x', 'x'}, {'x', 'x', 'x'}, {'x', 'x', 'x'}};
        found = findMatch(arr2, 3, "bad");
        if (found) {
            System.out.println("The word bad was found in the input array");
        } else {
            System.out.println("The word bad was not found in the input array");
        }
    }
}
