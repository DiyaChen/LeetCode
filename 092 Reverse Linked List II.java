/*
Reverse Linked List II  

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        for(int i = 0; i < m - 1; i++){
            start = start.next;
        }
        ListNode cur = start.next;
        while(n > m){
            n--;
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = start.next; // insert tmp before start.next;
            start.next = tmp;
        }
        return dummy.next;
    }
}

// Basic reverse method
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(head.next != null){
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }
}