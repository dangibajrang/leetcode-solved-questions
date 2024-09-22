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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: if the tree is empty, return an empty list
        if (root == null) {
            return result;
        }

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // BFS loop to process the tree level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();  // Get the current node

                // If it's the last node in the level, add it to the result
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                // Enqueue left and right children for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return result;  // Return the right side view
    }

    public static void main(String[] args) {
        // Create a sample binary tree:
        //        1
        //       / \
        //      2   3
        //       \   \
        //        5   4

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        Solution solution = new Solution();
        List<Integer> result = solution.rightSideView(root);

        // Print the result
        System.out.println(result);  // Output: [1, 3, 4]
    }
}
