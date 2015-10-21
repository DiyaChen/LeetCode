/*
Sum Root to Leaf Numbers 

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return DFS(root, 0);
    }
    
    private int DFS(TreeNode root, int num){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            num = num * 10 + root.val;
            return num;
        }
        num = num * 10 + root.val;
        return DFS(root.left, num) + DFS(root.right, num);
    }
}