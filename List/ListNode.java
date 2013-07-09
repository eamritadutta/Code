// Non - generic list node class
 
// Nodes in the list contain 'int' values

public class ListNode {
    
    // member variables of a class are 'protected' by default in Java
    int val;
    ListNode next;
    
    // constructor
    public ListNode(int val, ListNode next) {
        this.val = val;
	this.next = next;
    }
}
