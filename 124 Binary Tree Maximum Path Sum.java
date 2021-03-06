/*
Binary Tree Maximum Path Sum 

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;       
        int max = Integer.MIN_VALUE;
        calculate(root);
        return max;
    }
    
    private int calculate(TreeNode root){
            if(root == null) return 0;
            int leftSum = calculate(root.left);    // max sum of path that is end of root.left
            int rightSum = calculate(root.right);  // max sum of path that is start from root.right
            int currentSum = Math.max(root.val, Math.max(leftSum + root.val, rightSum + root.val)); // currentSum: the max sum of a path that is end of or start from root
            max = Math.max(max, Math.max(currentSum, leftSum + root.val + rightSum)); // path that contains root
            return currentSum;
    }
}