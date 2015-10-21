/*
Binary Tree Inorder Traversal 

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
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
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        aux(root, result);
        return result;
    }
    
    private void aux(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }else{
            aux(root.left, result);
            result.add(root.val);
            aux(root.right, result);
            return;
        }
    }
}