/*
Copy List with Random Pointer 

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();    // <original, clone>
        return dfs(head, map);
    }
    
    private RandomListNode dfs(RandomListNode head, Map<RandomListNode, RandomListNode> map){
        if(head == null) return null;
        if(!map.containsKey(head)){
            RandomListNode headClone = new RandomListNode(head.label); // clone the head
            map.put(head, headClone);
            headClone.next = dfs(head.next, map);
            headClone.random = dfs(head.random, map);
            return headClone;
        }else{
            return map.get(head);
        }
    }
}

//solution2
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode runner = head;
        HashMap<RandomListNode, RandomListNode> record = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        while(runner != null)
        {
            RandomListNode tmp = new RandomListNode(runner.label);
            record.put(runner, tmp);
            runner = runner.next;
            cur.next = tmp;
            cur = cur.next;
        }
        cur.next = null;
        cur = dummy.next;
        runner = head;
        while(runner != null)
        {
            if(runner.random == null) 
                cur.random = null;
            else cur.random = record.get(runner.random);
            runner = runner.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}