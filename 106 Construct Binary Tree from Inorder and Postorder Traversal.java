/*
Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null){
            return null;
        }
        return aux(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode aux(int[] in, int inStart, int inEnd, int[] po, int poStart, int poEnd){
        if(inStart > inEnd){
            return null;
        }
        int mid = inEnd;
        while(in[mid] != po[poEnd]){
            mid--;
        }
        TreeNode root = new TreeNode(po[poEnd]);
        root.left = aux(in, inStart, mid - 1, po, poStart, poStart + mid - 1 - inStart);
        root.right = aux(in, mid + 1, inEnd, po, poStart + mid - inStart, poEnd - 1);
        return root;
    }
}