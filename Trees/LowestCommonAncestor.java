import java.util.LinkedList;

public class LowestCommonAncestor {
    
    private static class Node {
        Node left; 
	Node right; 
	int data;

	// constructor
	public Node(int data, Node left, Node right) {
	    this.data = data;
	    this.left = left;
	    this.right = right;
	}
    }

    // returns a tree and 2 target nodes 'p' and 'q' whose targets we are about to find
    private static class TreeAndTargetNodes {
	Node root;
	// first target 
	Node p;
	// second target
	Node q;

	// constructor
	public TreeAndTargetNodes(Node root, Node p, Node q) {
	    this.root = root;
	    this.p = p;
	    this.q = q;
	}
    }
    
    private static TreeAndTargetNodes getTreeAndTargets() {
	Node six = new Node(6, null, null);
	Node eight = new Node(8, null, null);
	Node seven = new Node(7, six, eight);

	Node two = new Node(2, null, null);
	Node five = new Node(5, two, seven);

	Node fifteen = new Node(15, null, null);

	Node root = new Node(10, five, fifteen);
	
	// selecting nodes 'two' and 'eight' to be the targets
	return new TreeAndTargetNodes(root, two, eight);
    }

    // prints the nodes of an un-balanced binary tree level - by - level
    // using BFS
    private static void printTreeLevelByLevel(Node root) {
	LinkedList<Node> q = new LinkedList<Node>();
	q.add(root);
	
	// # of nodes in the level of tree whose children we are presently enqueuing
	int curr = 1;
	// # of nodes in the next level of tree i.e. total number of in the next level (of all nodes in current level)
	int next = 0;

	while (q.size() > 0) {
	    Node n = q.poll();
	    System.out.print(n.data + " ");
	    curr --;
	    
	    if (n.left != null) {
		q.offer(n.left);
		next ++;
	    }

	    if (n.right != null) {
		q.offer(n.right);
		next ++;
	    }

	    if (curr == 0) {
		curr = next; 
		next = 0;
		System.out.println();
	    }
	}
    }

    public static void main(String[] args) {
	TreeAndTargetNodes inputNodes = getTreeAndTargets();
	LCA result = getLowestCommonAncestor(inputNodes.root, inputNodes.p, inputNodes.q);

	System.out.println("Finding lowest common ancestor for the following tree :");
	printTreeLevelByLevel(inputNodes.root);

	System.out.println("The target nodes are the nodes with values: " + inputNodes.p.data + " and " + inputNodes.q.data);

	if (result.foundTrueAncestor == true) {
	    System.out.println("The lowest common ancestor of is: " + result.lca.data);
	} else {
	    System.out.println("The lowest common ancestor of is not present in the tree");
	}
    }
    
    private static class LCA {
	boolean foundTrueAncestor;
	Node lca;

	public LCA(Node lca, boolean foundTrueAncestor) {
	    this.lca = lca;
	    this.foundTrueAncestor = foundTrueAncestor;
	}
    }

    // either 'p' or 'q' or both may not exist in the tree rooted at 'root'
    private static LCA getLowestCommonAncestor(Node root, Node p, Node q) {
	// base case of recursion
	if (root == null) {
	    return new LCA(null, false);
	}

	LCA leftRes = getLowestCommonAncestor(root.left, p, q);
	if (leftRes.foundTrueAncestor) {
	    return leftRes;
	}

	LCA rightRes = getLowestCommonAncestor(root.right, p, q);
	if (rightRes.foundTrueAncestor) {
	    return rightRes;
	}
	
	
	if (root == p && leftRes.lca == null && rightRes.lca == null) {
	    return new LCA(root, false);
	}

	// target node is the LCA
	else if (root == p && (leftRes.lca != null || rightRes.lca != null)) {
	    return new LCA(root, true);
	}

	if (root == q && leftRes.lca == null && rightRes.lca == null) {
	    return new LCA(root, false);
	}

	// target node is the LCA
	else if (root == q && (leftRes.lca != null || rightRes.lca != null)) {
	    return new LCA(root, true);
	}

	if (leftRes.lca != null && rightRes.lca != null) {
	    return new LCA(root, true);
	}
	
	// either 'p' or 'q' or both 'p' and 'q' absent from the tree
        Node commonAnces = leftRes.lca != null ? leftRes.lca : rightRes.lca;
	return new LCA(commonAnces, false);
    }
    
}
