/*
Populating Next Right Pointers in Each Node II 

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null && root.right == null){
            return;
        }
        ArrayList<TreeLinkNode> current = new ArrayList<TreeLinkNode>();
        current.add(root);
        while(!current.isEmpty()){
            ArrayList<TreeLinkNode> next = new ArrayList<TreeLinkNode>();
            for(int i = 0; i < current.size(); i++){
                if(current.get(i).left != null){
                    next.add(current.get(i).left);
                }
                if(current.get(i).right != null){
                    next.add(current.get(i).right);
                }
                if(i == current.size()-1){
                    current.get(i).next = null;
                }else{
                    current.get(i).next = current.get(i+1);
                }
            }
            current = next;
        }
    }
}