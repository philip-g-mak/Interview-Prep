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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root){
        if(root == null) return 0;
        
        int leftMax = Math.max(0, helper(root.left));
        int rightMax = Math.max(0, helper(root.right));
        
        int pathTotal = root.val + leftMax + rightMax;
        
        max = Math.max(max, pathTotal);
        
        if(leftMax > rightMax){
            return leftMax + root.val;
        } else {
            return rightMax + root.val;
        }
    }
}

/*
idea 

get the left and right max value recursively
calcualte max value by node val + left sum + right sum



*/