/*
Count Complete Tree Nodes 

Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode left = root;
        TreeNode right = root;
        int hl = 0;
        int hr = 0;
        while(left != null){
            left = left.left;
            hl++;
        }
        while(right != null){
            right = right.right;
            hr++;
        }
        if(hl == hr){
            return (int)Math.pow(2, hr) - 1;
        }else{
            return countNodes(root.left) + 1 + countNodes(root.right);
        }
    }
}