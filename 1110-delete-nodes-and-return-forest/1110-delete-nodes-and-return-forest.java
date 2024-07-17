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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // List to store the remaining trees
        List<TreeNode> ans = new ArrayList<>();
        // Set to store the values to be deleted for quick lookup
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        // Start the DFS traversal
        dfs(root, toDeleteSet, true, ans);
        return ans;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> toDeleteSet, boolean isRoot, List<TreeNode> ans) {
        // Base case: if the node is null, return null
        if (root == null) {
            return null;
        }

        // Check if the current node needs to be deleted
        boolean deleted = toDeleteSet.contains(root.val);

        // If the current node is a root and is not deleted, add it to the answer list
        if (isRoot && !deleted) {
            ans.add(root);
        }

        // Recursively process the left and right children
        // If the current node is deleted, its children can be new roots
        root.left = dfs(root.left, toDeleteSet, deleted, ans);
        root.right = dfs(root.right, toDeleteSet, deleted, ans);

        // Return null if the current node is deleted, otherwise return the node itself
        return deleted ? null : root;
    }

   
}
