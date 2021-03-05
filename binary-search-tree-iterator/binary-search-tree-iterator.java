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
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        populateStack(root);
    }
    private void populateStack(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        
        
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode topNode = stack.pop();
        
        if(topNode.right != null){
            populateStack(topNode.right);
        }
        
        return topNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


/*
    inorder -> LEFT - PARENT - RIGHT
    essentially dfs
    
    
    2 ideas:
    1.  flatten the stack into an arraylist 
    
    2. use a stack to keep track of elements (all left elements)
        if stack.pop is called, add elements to the right of the popped node to the stack 
        
        so create method that adds all left nodes from root node to a stack
        when next is called, call that method with the popNode.right as root
        
        next would be !stack.isEmpty()
*/