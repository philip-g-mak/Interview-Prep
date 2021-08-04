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
    public List < List < Integer >> pathSum(TreeNode root, int targetSum) {
        Stack < Pair < TreeNode, Integer >> dfsStack = new Stack();
        List < List < Integer >> ret = new ArrayList();
        if (root == null)
            return ret;

        List < Integer > path = new ArrayList();

        

        int pathSum = 0;
        dfsStack.push(new Pair(root, 0));


        while (!dfsStack.isEmpty()) {
            Pair < TreeNode, Integer > tuple = dfsStack.pop();
            TreeNode node = tuple.getKey();
            int level = tuple.getValue();
            
            while (level < path.size()) {
                    path.remove(path.size() - 1);
                    
                }

            path.add(node.val);

            if (node.left == null && node.right == null) // we are at a leaf node
            {
                if (getSum(path) == targetSum) {
                    ret.add(new ArrayList(path));
                }
          
            } else {
                if (node.left != null)
                    dfsStack.push(new Pair(node.left, level + 1));
                if (node.right != null)
                    dfsStack.push(new Pair(node.right, level + 1));

            }

        }

         return ret;
    }
    
    public int getSum(List<Integer> sumList) {
            int sum = 0;

            for (Integer i: sumList)
                sum += i;

            return sum;
        }
}