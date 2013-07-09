/*
  Given matrix MxN of 0s and 1s, output all groups of adjacent 1s in form of SetID: (row,coll)... 1s are considered adjacent if they are adjacent horizontally or vertically.

1 1 0 1 0 1
1 1 1 1 0 1
0 0 0 0 1 1
1 0 1 0 1 0

*/

import java.util.ArrayList;

public class ListOfConsecutive1s {
    private static class Coordinates {
	int x;
	int y;
	
	public Coordinates(int x, int y) {
	    this.x = x;
	    this.y = y;
	}
    }

    public static void main(String[] args) {
	int[][] arr = {{1, 1, 0, 1, 0, 1}, {1, 1, 1, 1, 0, 1}, {0, 0, 0, 0, 1, 1}, {1, 0, 1, 0, 1, 0}};
	ArrayList<ArrayList<Coordinates>> allLists = getAdj1s(arr);


	for (ArrayList<Coordinates> list : allLists) {
	    for (Coordinates coord : list) {
		System.out.print( "(" + coord.x + "," + coord.y + ") ");
	    }
	    System.out.println();
	}
    }

    private static ArrayList<ArrayList<Coordinates>> getAdj1s(int[][] arr) {
	int col = arr[0].length;
	boolean[][] visited = new boolean[arr.length][col];

	ArrayList<ArrayList<Coordinates>> allList = new ArrayList<ArrayList<Coordinates>>();
	ArrayList<Coordinates> list = new ArrayList<Coordinates>();

	for (int i=0; i < arr.length; i++) {
	    for (int j=0; j < arr[0].length; j++) {
		if (arr[i][j] == 1 && visited[i][j] == false) {
		  
		    getAdj1s(arr, visited, i, j, list);
		  
		    if (list.size() > 0) {
			allList.add(list);
			list = new ArrayList<Coordinates>();
		    }
		}
	    }
	}

	return allList;
    }

    private static void getAdj1s(int[][] arr, boolean[][] visited, int r, int c, ArrayList<Coordinates> list) {
	// base case
	if (r < 0 || r == arr.length || c < 0 || c == arr[0].length) {
	    return;
	}
	
	if (arr[r][c] == 0 || visited[r][c] == true)
	    return;

	visited[r][c] = true;
	list.add(new Coordinates(r, c));

	getAdj1s(arr, visited, r+1, c, list);
	getAdj1s(arr, visited, r, c+1, list);
	getAdj1s(arr, visited, r-1, c, list);
	getAdj1s(arr, visited, r, c-1, list);
    }
}
