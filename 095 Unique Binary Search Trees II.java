/*
Unique Binary Search Trees II

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        return DP(1, n);
    }

    private List<TreeNode> DP(int begin, int end){  // return a list of ROOTs of tree, the roots rang from begin to end
        List<TreeNode> currList = new ArrayList<TreeNode>();
        if(begin > end){
            currList.add(null);
            return currList;
        }
        for(int i = begin; i <= end; i++){
            List<TreeNode> leftSubtrees = DP(begin, i - 1); // all the possible root of left
            List<TreeNode> rightSubtrees = DP(i + 1, end);  // all the possible root of right
            for(TreeNode leftRoot : leftSubtrees){
                for(TreeNode rightRoot : rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    currList.add(root);
                }
            }
        }
        return currList;
    }
}