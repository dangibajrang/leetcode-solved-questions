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
// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
        
//     }
// }
// import java.util.ArrayList;
// import java.util.List;

 class Solution {
    
    public static boolean findTarget(TreeNode root, int k) {
        // List to store the inorder traversal result
        List<Integer> nums = new ArrayList<>();
        // Perform inorder traversal to get a sorted list of elements
        inorderTraversal(root, nums);

        // Initialize two pointers
        int left = 0;
        int right = nums.size() - 1;

        // Two-pointer approach
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == k) {
                return true; // Found the target sum
            } else if (sum < k) {
                left++; // Move the left pointer to the right
            } else {
                right--; // Move the right pointer to the left
            }
        }

        // If no such elements are found
        return false;
    }

    // Helper method to perform inorder traversal kyoki ye node ko sort kr dega increasing //order me
    private static void inorderTraversal(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, nums);
        nums.add(root.val);
        inorderTraversal(root.right, nums);
    }
}
