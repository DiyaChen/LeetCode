/*
Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the nextNodes level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        List<TreeNode> currentNodes = new ArrayList<TreeNode>();
        currentNodes.add(root);
        int reverse = -1;
        
        while(!currentNodes.isEmpty()){
            List<Integer> currentIntegers = new ArrayList<Integer>();
            List<TreeNode> nextNodes = new ArrayList<TreeNode>();
            
            for(TreeNode tn : currentNodes){
                if(reverse == -1) currentIntegers.add(tn.val);
                else currentIntegers.add(0, tn.val);
                if(tn.left != null){
                    nextNodes.add(tn.left);
                }    
                if(tn.right != null){
                    nextNodes.add(tn.right);
                }
            }
            result.add(currentIntegers);
            currentNodes = nextNodes;
            reverse = - reverse;
        }
        return result;
    }
}