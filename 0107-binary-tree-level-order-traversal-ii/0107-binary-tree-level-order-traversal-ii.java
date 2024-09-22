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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Result list to store levels from bottom to top
        List<List<Integer>> result = new LinkedList<>();
        
        // Edge case: if the tree is empty, return an empty list
        if (root == null) {
            return result;
        }

        // Queue for BFS (Breadth-First Search) traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Start by adding the root node to the queue

        // BFS loop to process the tree level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            List<Integer> currentLevel = new ArrayList<>();  // List to store the values of the current level

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();  // Get and remove the front node in the queue
                currentLevel.add(currentNode.val);  // Add its value to the current level list

                // Add the left and right children to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Add the current level list at the beginning of the result list
            result.add(0, currentLevel);
        }

        // Return the result list, which will be from bottom to top
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
        
        // Get the bottom-up level order traversal
        List<List<Integer>> result = solution.levelOrderBottom(root);
        
        // Print the result
        System.out.println(result);  // Output: [[15, 7], [9, 20], [3]]
    }
}
