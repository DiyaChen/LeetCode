//Lowest Common Ancestor of a Binary Search Tree
/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || !isCover(root, p) || !isCover(root, q))//if p or q is not in the tree, we should return null. first check whether p or q is in the tree or not
            return null;
        if(root.val > Math.max(p.val, q.val))
            return lowestCommonAncestor(root.left, p, q);
        else if(root.val < Math.min(p.val, q.val))
            return lowestCommonAncestor(root.right, p, q);
        else 
            return root;
    }
    private Boolean isCover(TreeNode root, TreeNode n)
    {
        if(root == null)
            return false;
        if(root.val == n.val)
            return true;
        else 
            return isCover(root.left, n) || isCover(root.right, n);
    }
}
