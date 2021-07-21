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
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> nodeStack = new Stack();
        nodeStack.push(root);
        
        while(!nodeStack.isEmpty()){
            TreeNode topNode = nodeStack.pop();
            
            if(topNode.right != null) nodeStack.push(topNode.right);
            if(topNode.left != null) nodeStack.push(topNode.left);
            
            topNode.left = null;
            
            if(!nodeStack.isEmpty()) topNode.right = nodeStack.peek();
            
        }
    }
}

/*
pre-order of tree 

do dfs - using stack
*/