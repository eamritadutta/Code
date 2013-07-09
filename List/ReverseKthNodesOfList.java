public class ReverseKthNodesOfList {

    public static void main(String[] args) {
	ListNode head = new ListNode(7, null);
	head = new ListNode(6, head);
	head = new ListNode(5, head);
	head = new ListNode(4, head);
	head = new ListNode(3, head);
	head = new ListNode(2, head);
	head = new ListNode(1, head);
	head = new ListNode(0, head);

	printList(head);

	// hard-coding k = 3
	head = reverseEveryKthNode(head, 3);
	printList(head);
    }

    private static ListNode reverseEveryKthNode(ListNode head, int k) {
	if (k <= 0 || head == null || head.next == null) 
	    return head;

	ListNode newHead = null;
	
	ListNode prev = null;
	ListNode curr = head;
	ListNode start = head;
	ListNode last = null;

	while (curr != null) {
	    for (int i = 0; i < k && curr != null; i++) {
		prev = curr;
		curr = curr.next;
	    }

	    reverseGroup(start, prev);
	    
	    if (newHead == null) 
		newHead = prev;

	    if (last != null) 
		last.next = prev;

	    last = start;
	    start = curr;
	}
	
	return newHead;
    }

    private static void reverseGroup(ListNode st, ListNode end) {
	if (st == null || end == null)
	    return;

	ListNode prev = null;
	ListNode next = null;
	ListNode curr = st;

	while (curr != end) {
	    next = curr.next;
	    curr.next = prev;
	    prev = curr;
	    curr = next;
	}

	curr.next = prev;
    }

    private static void printList(ListNode head) {
	System.out.println();
	while (head != null) {
	    System.out.print(head.val + " -> ");
	    head = head.next;
	}
	System.out.println();
    }
}
