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



// Approach:
// 1.Use a Breadth-First Search (BFS) to traverse the tree level by level.
// 2.Maintain a flag to determine the direction of traversal for each level.
// 3.For each level, collect the node values in a list. Depending on the direction, either add them in normal order or reverse the order before adding to the result

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: if the tree is empty, return an empty list
        if (root == null) {
            return result;
        }

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;  // Direction flag

        // BFS loop to process the tree level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();  // Get and remove the front node

                // Add the current node's value based on the direction
                if (leftToRight) {
                    currentLevel.add(currentNode.val);  // Left to right
                } else {
                    currentLevel.add(0, currentNode.val);  // Right to left (insert at the beginning)
                }

                // Enqueue left and right children for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Toggle the direction for the next level
            leftToRight = !leftToRight;
            result.add(currentLevel);  // Add the current level to the result
        }

        return result;  // Return the zigzag level order result
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Create a sample binary tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        
        // Get the zigzag level order traversal
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        
        // Print the result
        System.out.println(result);  // Output: [[1], [3, 2], [4, 5, 6]]
    }
}
