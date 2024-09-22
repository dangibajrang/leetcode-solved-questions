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


//similar to 102  Binary Tree Level Order Traversal 
class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        // Result list to store the average of each level
        List<Double> result = new ArrayList<>();
        
        // Edge case: if the tree is empty, return an empty list
        if (root == null) {
            return result;
        }

        // Queue to facilitate level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Start BFS by adding the root node to the queue

        // Process the tree level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            double sum = 0;  // Sum of node values at the current level

            // Process each node at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();  // Get and remove the front node
                sum += currentNode.val;  // Add its value to the sum

                // Add the left and right children to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Compute the average for the current level and add to the result
            result.add(sum / levelSize);
        }

        // Return the list of averages
        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Create a sample binary tree: 
        //        3
        //       / \
        //      9  20
        //         /  \
        //        15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        // Get the average of levels
        List<Double> result = solution.averageOfLevels(root);
        
        // Print the result
        System.out.println(result);  // Output: [3.0, 14.5, 11.0]
    }
}
