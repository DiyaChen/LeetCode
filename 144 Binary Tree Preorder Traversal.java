/*
Binary Tree Preorder Traversal 

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        aux(root, results);
        return results;
    }
    
    public void aux(TreeNode root, ArrayList<Integer> results){
        if(root == null){
            return;
        }else{
            results.add(root.val);
            aux(root.left, results);
            aux(root.right, results);
            return;
        }
    }
}
