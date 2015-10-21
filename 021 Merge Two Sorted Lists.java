/*
Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode end = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                end.next = l1;
                end = end.next;
                l1 = l1.next;
            }else{
                end.next = l2;
                end = end.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            end.next = l2;
        }else{
            end.next = l1;
        }
        return dummy.next;
    }
}