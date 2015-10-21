/*
Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        return aux(preorder, 0, preLength - 1, inorder, 0, inLength - 1);
    }
    
    private TreeNode aux(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }
        int mid = inStart;
        while(in[mid] != pre[preStart]){
            mid++;
        }
        
        int len = mid - inStart;
        TreeNode root = new TreeNode(pre[preStart]);
        root.left = aux(pre, preStart + 1, preStart + len, in, inStart, mid - 1);
        root.right = aux(pre, preStart + len + 1, preEnd, in, mid + 1, inEnd);
        return root;
    }
}