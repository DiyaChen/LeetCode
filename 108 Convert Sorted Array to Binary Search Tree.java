/*
Convert Sorted Array to Binary Search Tree 

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0){
            return null;
        }else{
            return aux(num, 0, num.length-1);
        }
    }
    
    public TreeNode aux(int[] num, int a, int b){
        if(a > b){
            return null;
        }else if(a == b){
            return new TreeNode(num[a]);
        }else{
            int m = (a + b) / 2;
            TreeNode root = new TreeNode(num[m]);
            root.left = aux(num, a, m - 1);
            root.right = aux(num, m + 1, b);
            return root;
        }
    }
}