/*
Convert Sorted List to Binary Search Tree

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    static ListNode cur; 
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int len = 0;
        cur = head;
        while(cur != null)
        {
            len++;
            cur = cur.next;
        }
        cur = head;
        return buildTree(0,len-1);
    }
    private TreeNode buildTree(int s, int e)
    {
        if(s>e) return null;
        int mid = s+(e-s)/2;
        TreeNode n = new TreeNode(0);
        n.left = buildTree(s,mid-1);
        n.val = cur.val;
        cur = cur.next;
        n.right = buildTree(mid+1, e);
        return n;
    }
}


// A bad solution as Java passes object references by value as well
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int len = 0;
        ListNode runner = head;
        while(runner != null){
            runner = runner.next;
            len++;
        }
        return bottomUp(head, 0, len - 1);
    }
    
    private TreeNode bottomUp(ListNode head, int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = bottomUp(head, start, mid - 1); // ERORR! Java copies and PASS THE REFERENCE by value, not the object.
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        TreeNode right = bottomUp(head, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
