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
        ListNode dummy = new ListNode(-1);//the default f next is null.
        while(head.next!= null){ // until head is the last node
            ListNode pre = dummy;//dummy.next == null at first
            ListNode cur = head;
            head = head.next;
            while(pre.next != null && cur.val > pre.next.val)
                pre = pre.next;//not the insertion spot
            cur.next = pre.next;//insert
            pre.next = cur;           
        }
        return dummy.next;
    }
}