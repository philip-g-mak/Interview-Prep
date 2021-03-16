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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return maxDiameter;
        diameterHelper(root);
        return maxDiameter;
    }
    
    public int diameterHelper(TreeNode root){
        //we are at a leaf node
        if(root == null){
            return 0;
        }
        
        int leftLen = diameterHelper(root.left);
        int rightLen = diameterHelper(root.right);
        
        maxDiameter = Math.max(maxDiameter, leftLen + rightLen);
        return Math.max(leftLen, rightLen)+1;
        
    }
}

/*
idea recursion 

go all the way down to the leaf node then return 0
get the max of both left and right sides
keep track of max possible lengths and you work upward

*/