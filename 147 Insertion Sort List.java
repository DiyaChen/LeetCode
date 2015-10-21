/*
Insertion Sort List 

Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(head.next != null){    // until head is the last node
            ListNode cur = head.next;
            if(head.val <= cur.val){
                head = cur;
                cur = cur.next;
            }else{
                head.next = cur.next;
                ListNode start = dummy;
                while(cur.val > start.next.val){
                    start = start.next;
                }
                cur.next = start.next;
                start.next = cur;
            }
        }
        return dummy.next;
    }
}