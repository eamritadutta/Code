import java.util.ArrayList;

public class MinCostPathUsingDynamicProgramming {
    
    private static class Cell{
	int x;
	int y;

	public Cell(int x, int y) {
	    this.x = x;
	    this.y = y;
	}
    }

    public static void main(String[] args) {
	
	// create the matrix of costs 
	int[][] cost = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
	
	int costOfPath = minCostPathTo(cost);
	System.out.println("The cost of the (min cost path) path to (2,2) from (0,0) is: " + costOfPath);

    }
    
    private static ArrayList<Cell> getPath(int[][] costs) {
	// push (0,0)
	ArrayList<Cell> path = new ArrayList<Cell>();
	path.add(new Cell(0, 0));

	int r = 0;
	int c = 0;
	while (r+1 < costs.length && c+1 < costs[0].length) {
	    int min = min(costs[r+1][c], costs[r][c+1], costs[r+1][c+1]);
	    if (min == costs[r+1][c]) {
		r++;			
	    }
	    else if (min == costs[r][c+1]) {
		c ++;
		
	    }
	    else {
		r++;
		c++;
	    }
	    path.add(new Cell(r, c));
	}
	path.add(new Cell(2, 2));
	return path;
    }
    

    // returns min of 3 #s
    private static int min(int a, int b, int c) {
	if (a <= b && a <= c) {
	    return a;
	}

	else if (b <= a && b <= c) {
	    return b;
	}

	else 
	    return c;
    }

    private static int minCostPathTo(int[][] cost) {
	// create the min - cost matrix using cost 
	
	int r = cost.length;
	int c = cost[0].length;

	int[][] minCostTo = new int[r][c];
	minCostTo[0][0] = cost[0][0];

	// 1st row
	for (int i = 1; i < c; i++) 
	    minCostTo[0][i] = cost[0][i] + minCostTo[0][i-1];

	// 1st col
	for (int i = 1; i < r; i++) 
	    minCostTo[i][0] = cost[i][0] + minCostTo[i-1][0];

	for (int row = 1; row < r; row++) {
	    for (int col = 1; col < c; col++) {
		minCostTo[row][col] = cost[row][col] + min( minCostTo[row-1][col], minCostTo[row][col-1], minCostTo[row-1][col-1]);
	    }
	}

	ArrayList<Cell> path = getPath(minCostTo); // assuming (0,0) to (2,2)
	for (Cell z : path) {
	    System.out.println(z.x + ", " + z.y);
	}
       
	return minCostTo[2][2];
    }
}
