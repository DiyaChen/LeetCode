/*
Reverse Linked List 

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode second = head.next;
        head.next = null;

        ListNode newHead = reverseList(second);
        second.next = head;
        return newHead;
    }
}

//

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