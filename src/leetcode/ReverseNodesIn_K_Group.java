/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 * */
package leetcode;

public class ReverseNodesIn_K_Group {
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		if (head.next == null || k == 1) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode from = dummy;
		ListNode to = dummy;
		boolean isNotEnd = true;
		while (isNotEnd) {
			for (int i = 0; i < k; i++) {
				if (to.next != null)
					to = to.next;
				else {
					isNotEnd = false;
					break;
				}
			}
			if (isNotEnd) {
				ListNode temp1 = from.next;
				ListNode temp2 = to;
				to = to.next;
				reverseK(temp1, temp2);
				temp1.next = to;
				from.next = temp2;
				from = temp1;
				to = temp1;
			}
		}
		return dummy.next;
	}

	public static void reverseK(ListNode head, ListNode tail) {
		ListNode cur = head;
		ListNode temp = head.next;
		while (temp != null) {

			ListNode temp2 = temp.next;
			temp.next = cur;
			if (temp == tail) {
				break;
			}
			cur = temp;
			temp = temp2;

		}
		head.next = null;
	}
}
