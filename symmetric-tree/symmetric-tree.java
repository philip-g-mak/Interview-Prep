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
   public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            
            if((t1 == null && t2 != null) ||(t1 != null && t2 == null))
                return false;
            
            if(t1 == null && t2 == null) continue;
            
            
            if(t1.val != t2.val){
                return false;
            }

            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        
        }
        return true;
    }
   
    
//     public boolean isSymmetric(TreeNode root) {
//         if(root == null) return true;
//        return helper(root.left, root.right);
//     }
    
//     public boolean helper(TreeNode t1, TreeNode t2){
//         if(t1 == null && t2 == null){
//             return true;
//         }
        
//         if(t1 == null || t2 == null){
//             return false;
//         }
        
//         if(t1.val != t2.val){
//             return false;
//         }
        
//         return helper(t1.left, t2.right) && helper(t1.right, t2.left);  
//     }
}

/*
iterative 
    BFS using a q, but input it such that it should be mirrored elements when coming out
    take 2 treenodes out at a time
     t1     t2
    / \    /  \
   a   b  c    d
a  = b
b = c

t1.left = t2.right
t1.right = t2.left


put into q in that order
t1 left, t2 right, t1 right, t2 left

allow nulls to be in q but do a lot of checking if one value is null and one value is not




recursive
same bfs idea
   2 nodes compared
    check t1.left vs t2.right and t2.left vs t1.right 
*/