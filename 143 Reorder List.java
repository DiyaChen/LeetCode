/*
Reorder List 

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode head3 = reverse(head2);
        merge(head, head3);
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(head.next != null){    // until head is last node
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }
    
    private ListNode merge(ListNode n1, ListNode n2){
        ListNode dummy = new ListNode(-1);
        ListNode end = dummy;
        int f = 1;
        while(n2 != null){
            if(f == 1){
                end.next = n1;
                n1 = n1.next;
                f = f + 1;
            }else{
                end.next = n2;
                n2 = n2.next;
                f = f - 1;
            }
            end = end.next;
        }
        end.next = n1;
        return dummy.next;
    }
}