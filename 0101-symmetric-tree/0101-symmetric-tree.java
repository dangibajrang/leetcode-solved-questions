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
        if (root == null) {
            return true; // An empty tree is symmetric
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            // Check if both nodes are null (symmetric)
            if (leftNode == null && rightNode == null) {
                continue;
            }
            // Check if only one of the nodes is null (not symmetric)
            if (leftNode == null || rightNode == null) {
                return false;
            }
            // Check if the values of the nodes are different
            if (leftNode.val != rightNode.val) {
                return false;
            }

            // Add the children in the order that checks symmetry
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }

        return true; // If we finish the loop, the tree is symmetric
    }

    public static void main(String[] args) {
        // Create a sample symmetric binary tree:
        //        1
        //       / \
        //      2   2
        //     / \ / \
        //    3  4 4  3

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Solution solution = new Solution();
        boolean result = solution.isSymmetric(root); // Output: true
        System.out.println(result);
    }
}
