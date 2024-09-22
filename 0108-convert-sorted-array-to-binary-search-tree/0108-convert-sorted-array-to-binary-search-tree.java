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

    // Method to convert a sorted array into a height-balanced BST
    public TreeNode sortedArrayToBST(int[] nums) {
        // Call the helper function with the full range of the array
        return helper(nums, 0, nums.length - 1);
    }

    // Helper method to recursively build the tree
    private TreeNode helper(int[] nums, int left, int right) {
        // Base case: if left pointer exceeds right, return null (no node to create)
        if (left > right) {
            return null;
        }

        // Choose the middle element of the current range as the root node to keep the tree balanced
        int mid = left + (right - left) / 2;  // Prevent overflow

        // Create the root node with the middle element
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively construct the left subtree with elements to the left of the middle
        root.left = helper(nums, left, mid - 1);

        // Recursively construct the right subtree with elements to the right of the middle
        root.right = helper(nums, mid + 1, right);

        // Return the current root node
        return root;
    }

    public static void main(String[] args) {
        // Example input: a sorted array
        int[] nums = {-10, -3, 0, 5, 9};

        // Create an instance of the solution class
        Solution solution = new Solution();

        // Convert the sorted array to a height-balanced BST
        TreeNode root = solution.sortedArrayToBST(nums);

        // Output the root value of the created BST (for demonstration purposes)
        System.out.println("Root of the BST: " + root.val);
    }
}
