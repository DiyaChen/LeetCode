/*
Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        List<TreeNode> currentNodes = new ArrayList<TreeNode>();
        currentNodes.add(root);

        while(!currentNodes.isEmpty()){
            List<Integer> currentIntegers = new ArrayList<Integer>();
            List<TreeNode> nextNodes = new ArrayList<TreeNode>();
            
            for(TreeNode tn : currentNodes){
                currentIntegers.add(tn.val);
                if(tn.left != null){
                    nextNodes.add(tn.left);
                }    
                if(tn.right != null){
                    nextNodes.add(tn.right);
                }
            }
            result.add(currentIntegers);
            currentNodes = nextNodes;
        }
        return result;
    }
}