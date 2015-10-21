/*
Sort List

Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1, head2);
    }
    
    private ListNode merge(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode end = dummy;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                end.next = head1;
                head1 = head1.next;
            }else{
                end.next = head2;
                head2 = head2.next;
            }
            end = end.next;
        }
        if(head1 == null){
            end.next = head2;
        }
        if(head2 == null){
            end.next = head1;
        }
        return dummy.next;
    }
}
