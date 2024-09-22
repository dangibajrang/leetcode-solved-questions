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
public class Solution {
    // Method to perform level order traversal of the binary tree.
    public List<List<Integer>> levelOrder(TreeNode root) {
        // If the root is null, return an empty list.
        if (root == null)
            return new ArrayList<>();

        // List to store the final level order traversal.
        List<List<Integer>> ans = new ArrayList<>();
        
        // Queue to perform level order traversal. Initialize with the root node.
        Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));

        // Process nodes level by level.
        while (!q.isEmpty()) {
            // List to store nodes at the current level.
            List<Integer> currLevel = new ArrayList<>();
            
            // Iterate through all nodes at the current level.
            for (int sz = q.size(); sz > 0; --sz) {
                // Dequeue a node from the front of the queue.
                TreeNode node = q.poll();
                
                // Add the node's value to the current level list.
                currLevel.add(node.val);
                
                // Enqueue the left child if it exists.
                if (node.left != null)
                    q.offer(node.left);
                
                // Enqueue the right child if it exists.
                if (node.right != null)
                    q.offer(node.right);
            }
            
            // Add the current level list to the final result list.
            ans.add(currLevel);
        }

        // Return the final level order traversal list.
        return ans;
    }
}