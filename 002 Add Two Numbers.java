/*
Add Two Numbers

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int sum = 0;
        while(l1 != null || l2 != null)
        {
            if(l1!= null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!= null)
            {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum%10);
            sum = sum/10;
            cur = cur.next;
        }
        if(sum > 0 )
        {
             cur.next = new ListNode(sum);
        }
       return pre.next; 
    }
}