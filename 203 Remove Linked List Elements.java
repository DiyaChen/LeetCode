/*
Remove Linked List Elements 

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode end = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                cur = cur.next;
                end.next = cur;
            }else{
                end.next = cur;
                end = cur;
                cur = cur.next;
            }  
        }
        return dummy.next;
    }
}