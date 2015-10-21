/*
Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return aux(min, root, max);
    }
    
    private boolean aux(long min, TreeNode root, long max){
        if(root == null){
            return true;
        }
        
        if(min < root.val && root.val < max && aux(min, root.left, root.val) && aux(root.val, root.right, max)){
            return true;
        }
        return false;
    }
}