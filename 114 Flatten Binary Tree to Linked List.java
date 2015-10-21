/*
Flatten Binary Tree to Linked List 

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// iterative solution
public class Solution {
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left != null){
                TreeNode n = root.left;
                while(n.right != null){
                    n = n.right;
                }
                n.right = root.right;;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}

// recursive solution
public class FlattenBinaryTreeToLinkedList {
    private TreeNode lastNode = null;

    public void flatten(TreeNode root){
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;  // backup right child
        flatten(root.left);
        flatten(right);
    }
}