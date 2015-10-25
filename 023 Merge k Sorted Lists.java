/*
Merge k Sorted Lists 

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.PriorityQueue;
 
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){//pq's length, how to sort
            public int compare(ListNode n1, ListNode n2){
                if(n1.val < n2.val){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        for(ListNode ln : lists){
            if(ln != null){
                queue.add(ln);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode end = dummy;
        while(queue.size() > 0){
            ListNode tmp = queue.poll();
            end.next = tmp;
            end = end.next;
            if(tmp.next != null){
                queue.add(tmp.next);
            }
        }
        return dummy.next;
    }
}