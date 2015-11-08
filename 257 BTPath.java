//Binary Tree Paths
//Given a binary tree, return all root-to-leaf paths.

//For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
//All root-to-leaf paths are:

//["1->2->5", "1->3"]


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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null)
            return res;
        dfs(root, res, "");
        return res;
    }
    private void dfs(TreeNode root, List<String> res, String cur)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            res.add(cur + root.val);
            return;
        }
        dfs(root.left, res, cur + root.val + "->");
        dfs(root.right,res, cur + root.val + "->");
    }
}