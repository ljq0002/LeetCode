/*Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * */
package leetcode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		if (head.next.next == null) {
			ListNode newhead = head.next;
			newhead.next = head;
			head.next = null;
			return newhead;
		}
		ListNode newhead = head.next;
		ListNode subnode = newhead.next;
		newhead.next = head;
		head.next = swapPairs(subnode);
		return newhead;
	}
}
