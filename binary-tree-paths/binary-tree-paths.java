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
    List<String> result = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return result;
        StringBuilder sb = new StringBuilder();
        
        helper(root, sb);
        return result;
    }
    
    public void helper(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val);
        
        if(root.left == null && root.right == null){
            result.add(sb.toString());
            return;
        }
        
        sb.append("->");
        String partialPathString = sb.toString();
        helper(root.left, new StringBuilder(partialPathString));
        helper(root.right, new StringBuilder(partialPathString));
    }
}

/*
recursion - go through entire graph to find leaf node
once found - return 
    prepend the nodes value 

*/