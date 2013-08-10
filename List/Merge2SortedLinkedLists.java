public class Merge2SortedLinkedLists {

    public static void main(String[] agrs) {
  	test1();
	test2();
	test3();
    }

    private static ListNode mergeLists(ListNode h1, ListNode h2) {
	if (h1 == null && h2 == null) {
	    return null;
	}

	if (h1 == null) 
	    return h2;

	if (h2 == null) 
	    return h1;

	ListNode newHead = null;
	ListNode prev = null;
	while (h1 != null && h2 != null) {
	    if (h1.val <= h2.val) {
		if (newHead == null) {
		    newHead = h1;
		}
		prev = h1;
		h1 = h1.next;
	    } else {
		if (prev == null) {
		    newHead = h2;
		}
		else {
		    prev.next = h2;
		}
		ListNode temp = h2.next;
		h2.next = h1;
		prev = h2;
		h2 = temp;
	    }
	}
	if (h2 != null) {
	    prev.next = h2;
	}
	return newHead;
    }

    private static void test1() {
	int[] values = {1, 3, 5, 7, 9};
	ListNode head1 = List.getSinglyLinkedList(values);
	List.printSinglyLinkedList(head1);
	
	int[] moreValues = {0, 2, 4, 6, 8, 10};
	ListNode head2 = List.getSinglyLinkedList(moreValues);
	List.printSinglyLinkedList(head2);

	ListNode mergedList = mergeLists(head1, head2);
	System.out.println("Merged Lists:");
	List.printSinglyLinkedList(mergedList);
    }

    private static void test2() {
	int[] values = {1, 2, 3, 4, 5};
	ListNode head1 = List.getSinglyLinkedList(values);
	List.printSinglyLinkedList(head1);
	
	int[] moreValues = {0, 6, 7, 8, 9, 10};
	ListNode head2 = List.getSinglyLinkedList(moreValues);
	List.printSinglyLinkedList(head2);

	ListNode mergedList = mergeLists(head1, head2);
	System.out.println("Merged Lists:");
	List.printSinglyLinkedList(mergedList);
    }

    private static void test3() {
	int[] values = {0, 2, 4, 6, 8, 10};
	ListNode head1 = List.getSinglyLinkedList(values);
	List.printSinglyLinkedList(head1);
	
	int[] moreValues = {1, 3, 5, 7, 9};
	ListNode head2 = List.getSinglyLinkedList(moreValues);
	List.printSinglyLinkedList(head2);

	ListNode mergedList = mergeLists(head1, head2);
	System.out.println("Merged Lists:");
	List.printSinglyLinkedList(mergedList);
    }
}
