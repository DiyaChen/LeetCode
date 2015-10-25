/*
Intersection of Two Linked Lists 

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        for(int i = 0; i< Math.abs(lenB-lenA);i++)
        {
            if(lenA < lenB) headB = headB.next;
            else headA = headA.next;
        }
        while(headA != null && headB != null)
        {
            if(headA != headB)
            {
                headA = headA.next;
                headB = headB.next;
            }else return headA;
        }
        return null;
    }
    public int getLen(ListNode head)
        {
            int l = 0;
            while(head != null)
            {
                l++;
                head = head.next;
            }
            return l;
        }
}
