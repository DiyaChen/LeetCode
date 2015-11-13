3/*
Partition List 

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;
        while(cur != null && cur.next != null)
        {
            if(cur.next.val < x)
            {
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}