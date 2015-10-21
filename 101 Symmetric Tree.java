/*
Symmetric Tree 

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
// recursive solution
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
         return aux(root.left, root.right);
    }
    
    public boolean aux(TreeNode left, TreeNode right){
        if(left == null){
            return (right == null);
        }else{
            if(right == null){
                return false;
            }
        }
        if(left.val != right.val){
            return false;
        }
        return aux(left.left, right.right) && aux(left.right, right.left);
    }
}


//  iterative solution

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.empty()){
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
}