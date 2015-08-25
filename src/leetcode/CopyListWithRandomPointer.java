/*
	 * A linked list is given such that each node contains an additional random
	 * pointer which could point to any node in the list or null.
	 * 
	 * Return a deep copy of the list.
	 */
package leetcode;

public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode temp = new RandomListNode(cur.label);
			temp.next = cur.next;
			cur.next = temp;
			temp.random = cur.random;
			cur = cur.next;
			cur = cur.next;
		}
		cur = head.next;
		while (cur != null) {
			if (cur.random != null) {
				cur.random = cur.random.next;
			}
			cur = cur.next;
			if (cur != null) {
				cur = cur.next;
			}
		}
		RandomListNode dummy = new RandomListNode(-1);
		RandomListNode dummycur = dummy;
		cur = head;
		while (cur != null) {
			dummycur.next = cur.next;
			cur.next = cur.next.next;
			dummycur = dummycur.next;
			cur = cur.next;
		}
		return dummy.next;
	}
}
