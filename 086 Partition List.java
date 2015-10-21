/*
Partition List 

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode smallRunner = smallHead;
        ListNode bigRunner = bigHead;
        while(head != null){
            if(head.val < x){
                smallRunner.next = head;
                smallRunner = smallRunner.next;
            }else{
                bigRunner.next = head;
                bigRunner = bigRunner.next;
            }
            head = head.next;
        }
        bigRunner.next = null;
        smallRunner.next = bigHead.next;
        return smallHead.next;
    }
}