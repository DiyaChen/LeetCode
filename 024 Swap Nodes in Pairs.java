/*
Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur != null && cur.next != null && cur.next.next != null){
            cur.next = swap(cur.next, cur.next.next);
            cur = cur.next.next;
        }
        return dummy.next;
    }
    
    ListNode swap(ListNode n1, ListNode n2){
        n1.next = n2.next;
        n2.next = n1;
        return n2;
    }
}