/*Merge two sorted linked lists and return it as a new list.
 *  The new list should be made by splicing together the nodes of the first two lists.
 * */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		Queue sto = new LinkedList();
		ListNode h1 = l1;
		ListNode h2 = l2;

		while (h1 != null || h2 != null) {
			if (h1 != null && h2 != null) {
				sto.add(h1.val < h2.val ? h1 : h2);
				if (h1.val < h2.val) {
					h1 = h1.next;
				} else {
					h2 = h2.next;
				}
			}
			if (h1 != null && h2 == null) {
				sto.add(h1);
				h1 = h1.next;
			}
			if (h1 == null && h2 != null) {
				sto.add(h2);
				h2 = h2.next;
			}
		}
		if (sto.size() == 0) {
			return null;
		}
		ListNode head = (ListNode) sto.poll();
		ListNode cur = head;
		while (sto.size() != 0) {
			cur.next = (ListNode) sto.poll();
			cur = cur.next;
		}
		return head;

	}
}
