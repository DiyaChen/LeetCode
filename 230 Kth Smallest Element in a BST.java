/*
Kth Smallest Element in a BST 

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
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
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2];
        inorder(root, k, result);
        return result[1];
    }
    
    private void inorder(TreeNode root, int k, int[] result){
        if(root == null) return;
        inorder(root.left, k, result);
        result[0]++;
        if(result[0] == k){
            result[1] = root.val;
            return;
        }
        inorder(root.right, k, result);
    }
}