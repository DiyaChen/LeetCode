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
//BFS
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
             List<Integer> cur = new ArrayList<Integer>();
             int size = q.size();
            for(int i= 0; i< size; i++)
            {
                 TreeNode n = q.poll();
                 cur.add(n.val);
                 if(n.left != null) q.add(n.left);
                 if(n.right != null) q.add(n.right);
            }
           res.add(cur); 
        }
        return res;
    }
}
//DFS
public class Solution{
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(root, res, 0);
        return res;
    }
    private void dfs(TreeNode root, List<List<Integer>> res, int level)
    {
        if(root == null){
            return ;
        }
         List<Integer> cur = new ArrayList<Integer>();
         if(res.size() == level)
         {
             cur.add(root.val);
             res.add(cur);
         }
         else{
             res.get(level).add(root.val);
         }
        dfs(root.left, res, level+1);
        dfs(root.right, res, level+1);
    }
}