/*
Recover Binary Search Tree

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
    public void recoverTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;
        find(root);
        swap(first, second);
    }
    
    private void find(TreeNode curr){   // inorder traverse
        if(curr == null) return;
        find(curr.left);
        if(pre == null){
            pre = curr;
        }else if(pre.val > curr.val){ // violate the binary search tree rule
            if(first == null){
                first = pre;
            }
            second = curr;
        }
        pre = curr;
        find(curr.right);
    }
    
    private void swap(TreeNode f, TreeNode s){
        int tmp = f.val;
        f.val = s.val;
        s.val = tmp;
    }
}