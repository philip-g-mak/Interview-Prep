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
    public TreeNode pruneTree(TreeNode root) {
        return helper(root) ? root : null;
    }
    
    public boolean helper(TreeNode node){
        if(node == null) return false;
        
        boolean left1 = helper(node.left);
        boolean right1 = helper(node.right);
        
        if(!left1) node.left = null;
        if(!right1) node.right = null;
        
        return node.val == 1 || left1 || right1;
    }
}