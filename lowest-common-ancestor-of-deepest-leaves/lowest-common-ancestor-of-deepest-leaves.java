/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null || height(root.left) == height(root.right)) return root;
    
        return height(root.left) > height(root.right) ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right); 
    }
    
    
    public int height(TreeNode root){
        if(root == null) return 0;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}