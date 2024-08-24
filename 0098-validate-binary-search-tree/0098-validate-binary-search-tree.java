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
   // Method to validate if a binary tree is a valid BST.
    public boolean isValidBST(TreeNode root) {
        // Start with the entire range of possible integer values.
        return validate(root, null, null);
    }

    // Helper method to validate the tree recursively.
    private boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) return true; // A null node is always a valid BST.
        
        // The current node's value must be within the range defined by low and high.
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }
        
        // Recursively validate the left subtree and right subtree.
        // The left subtree must have all values less than the current node's value.
        // The right subtree must have all values greater than the current node's value.
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}