public class MinCostPathRecomputeOverlapping {
    
    public static void main(String[] args) {
	
	// create the matrix of costs 
	int[][] cost = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
	
	int costOfPath = minCostPathTo(2, 2, cost);
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

    private static int minCostPathTo(int r, int c, int[][] cost) {
	// base case
	if (r < 0 || c < 0) {
	    return Integer.MAX_VALUE;
	}

	if (r==0 && c==0) 
	    return cost[0][0];

	int x = min( minCostPathTo(r, c-1, cost), minCostPathTo(r-1, c, cost), minCostPathTo(r-1, c-1, cost));
	return  (x + cost[r][c]);
    }
}
