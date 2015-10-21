/*
Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while(end != null){
            for(int i = 0; i < k; i++){
                end = end.next;
                if(end == null) return dummy.next;
            }
            pre = end = reverse(pre, end);
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode pre, ListNode end){
        ListNode cur = pre.next;
        while(pre.next != end){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return cur;
    }
}