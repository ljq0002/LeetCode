/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * */

package leetcode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
        {
        	return l2;
        }
        if(l2 == null)
        {
        	return l1;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        boolean increase = false;
        ListNode cur_l1 = l1;
        ListNode cur_l2 = l2;
        while(cur_l1 != null || cur_l2 != null)
        {
        	int temp = 0;
        	temp += cur_l1 == null ? 0 : cur_l1.val;
        	temp += cur_l2 == null ? 0 : cur_l2.val;
        	temp += increase ? 1 : 0;
        	increase = false;
        	
        	cur.next = new ListNode(temp%10);
        	cur = cur.next;
        	increase = temp > 9 ? true : false; 
        	
        	cur_l1 = cur_l1 == null ? null : cur_l1.next;
        	cur_l2 = cur_l2 == null ? null : cur_l2.next;
        }
        
        if(increase)
        {
        	cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
