/*
A static libray of methods for various 'out-of-the-box' linked list methods.
*/

public class List {
    
    /* Creates a singly linked list from the values contained in the passed-in 'int' array */
    public static ListNode getSinglyLinkedList(int[] values) {
  	ListNode head = null;
	ListNode last = null;
	for (int val : values) {
	    if (head == null) {
		head = new ListNode(val, null);
		last = head;
	    } else {
		ListNode newNode = new ListNode(val, null);
		last.next = newNode;
		last = newNode;
	    }
	}
	return head;
    }
    
    /* Prints a singly linked list with the first node's refrence passed-in as 'head' */
    public static void printSinglyLinkedList(ListNode head) {
	System.out.println();
	while (head != null) {
	    if (head.next != null) 
		System.out.print(head.val + "->");
	    else 
		System.out.print(head.val);
	    head = head.next;
	}
	System.out.println();
	System.out.println();
    }
}
