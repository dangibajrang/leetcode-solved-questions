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
    public TreeNode invertTree(TreeNode root) {
          if (root == null) return null; // If the tree is empty, return null.

        Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // Dequeue a node.

        // Swap the left and right children.
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

        // Enqueue the left and right children to continue the process.
             if (current.left != null) queue.add(current.left);
             if (current.right != null) queue.add(current.right);
        }

        return root; // Return the root after inverting
    }
}