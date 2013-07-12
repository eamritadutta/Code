public class MinCostPathUsingDynamicProgramming {
    
    public static void main(String[] args) {
	
	// create the matrix of costs 
	int[][] cost = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
	
	int costOfPath = minCostPathTo(cost);
	System.out.println("The cost of the (min cost path) path to (2,2) from (0,0) is: " + costOfPath);
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
       
	return minCostTo[2][2];
    }
}
