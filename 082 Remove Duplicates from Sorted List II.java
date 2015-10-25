/*
Remove Duplicates from Sorted List II 

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;//skip all dup
            }
            if(pre.next == cur) pre = cur; // no dup
            else pre.next = cur.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}