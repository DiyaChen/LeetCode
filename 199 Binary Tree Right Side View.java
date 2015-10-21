/*
Binary Tree Right Side View 

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        bfs(result, queue);
        return result;
    }
    
    private void bfs(List<Integer> result, List<TreeNode> queue){
        while(queue.size() != 0){
            result.add(queue.get(queue.size() - 1).val);
            List<TreeNode> childQueue = new ArrayList<TreeNode>();
            for(TreeNode tn : queue){
                if(tn.left != null){
                    childQueue.add(tn.left);
                }
                if(tn.right != null){
                    childQueue.add(tn.right);
                }
            }
            queue = childQueue;
        }
    }
}