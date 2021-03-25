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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList();
        inorderTraverse(root, inorderList);
        return inorderList.get(k-1);
    }
    
    public List<Integer> inorderTraverse(TreeNode root, List<Integer> inorderList){
        if(root == null) return inorderList;
        
        inorderTraverse(root.left,inorderList );
        inorderList.add(root.val);
        inorderTraverse(root.right, inorderList);
        
        return inorderList;
    }
}



/*
InOrder traversal

add notes to some list
since it is inorder, itll be low -> high

return k-1 element in list
*/