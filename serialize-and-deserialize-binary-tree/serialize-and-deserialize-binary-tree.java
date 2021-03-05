/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "N";
        
        return root.val + "," + serialize(root.left) +"," +  serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList(List.of(data.split(",")));
        return helper(q);
    }
    
    public TreeNode helper(Queue<String> q){
        String valStr = q.poll();
        if(valStr.equals("N")) return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(valStr));
        root.left = helper(q);
        root.right = helper(q);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

/*
inorder
root - left - right

2 3 N 3 4 5 


BFS to reconstruct
*/