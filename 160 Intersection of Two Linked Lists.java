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
        if(headA == null || headB == null){
            return null;
        }
        ListNode runnerA = headA;
        ListNode runnerB = headB;
        int countA = 0;
        int countB = 0;
        while(runnerA != null){
            countA++;
            runnerA = runnerA.next;
        }
        while(runnerB != null){
            countB++;
            runnerB = runnerB.next;
        }
        runnerA = headA;
        runnerB = headB;
        if(countA > countB){
            for(int i = 0; i < countA-countB; i++){
                runnerA = runnerA.next;
            }
        }else if(countA < countB){
            for(int j = 0; j < countB-countA; j++){
                runnerB = runnerB.next;
            }
        }
        while(runnerA != runnerB){
            runnerA = runnerA.next;
            runnerB = runnerB.next;
        }
        return runnerA;
    }
}
