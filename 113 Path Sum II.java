/*
Path Sum II 

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        aux(result, list, root, sum);
        return result;
    }
    
    private void aux(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum){
        if(root.left == null && root.right == null){
            if(root.val == sum){
                List<Integer> newlist = new ArrayList<Integer>(list);
                newlist.add(root.val);
                result.add(newlist);
            }
        }
        if(root.left != null){
            list.add(root.val);
            aux(result, list, root.left, sum - root.val);
            list.remove(list.size() - 1);
        }
        if(root.right != null){
            list.add(root.val);
            aux(result, list, root.right, sum - root.val);
            list.remove(list.size() - 1);
        }
    }
}