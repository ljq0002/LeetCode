/*
    Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
    */
package leetcode;

public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int length = 0;
		ListNode temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		if (n == 1) {
			if (length == 1) {
				return null;
			} else {
				ListNode cur = head;
				for (int i = 0; i < length - n - 1; i++) {
					cur = cur.next;
				}
				cur.next = null;
			}
		} else {
			if (n == length) {
				ListNode cur = head;
				cur = cur.next;
				head.next = null;
				return cur;
			} else {
				ListNode pre = head;

				for (int i = 0; i < length - n - 1; i++) {
					pre = pre.next;
				}
				ListNode after = pre.next.next;
				pre.next.next = null;
				pre.next = after;
			}
		}
		return head;
	}
}
