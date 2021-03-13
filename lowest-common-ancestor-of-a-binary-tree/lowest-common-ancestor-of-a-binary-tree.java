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
        if(root == p || root == q || root == null)
            return root;
        
        TreeNode leftLCA = lowestCommonAncestor(root.left, p ,q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p ,q);
        
        //if neighther left lca or right lca are null, then the root is the lca
        if(leftLCA != null && rightLCA != null){
            return root;
        }
        
        return leftLCA == null ? rightLCA : leftLCA;
    }
}

/*
idea - 
bottom up 

find each node p and q
then send the nodes upward until common one is reached 
*/