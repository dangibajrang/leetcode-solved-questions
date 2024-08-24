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
  
    // Method to check if subRoot is a subtree of root.
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false; // Base case: If root is null, return false.
        if (isSameTree(root, subRoot)) return true; // If trees match, return true.
        // Recursively check the left and right subtrees.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper method to check if two trees are identical.
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true; // Both nodes are null, so they are the same.
        if (s == null || t == null) return false; // One of the nodes is null, so they aren't the same.
        if (s.val != t.val) return false; // Values of nodes don't match.
        // Recursively check left and right children.
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}