/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        
        if(leftLCA != null && rightLCA != null){
            return root;
        }
        
        return leftLCA == null ? rightLCA : leftLCA;
    }
}

/*
idea - search left and right subtrees

if the current (sub)tree contains both p and q, then lca is the root.  if only one lca is found, we know the other is not found in the other subtree therefore the lca is the p or q element we found


either will be subtree-root node - or node p or q itself
reasoning, if we leftcla and right cla are both found, the rootnode is the lowest ancestor by the fact that its the root of the tree

if only one is found, that means we exhaused searched one subtree (left or right) and it was not there.  thereforce it must be beneath the the lca we did find.  
so the lca is the p or q node we found.
*/