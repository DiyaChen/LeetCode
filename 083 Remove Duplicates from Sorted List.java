/*
Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
        ListNode cur = head;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}

//

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            while(cur != null && cur.val == pre.val){
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            if(cur != null){
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}