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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private int runningSum = 0;
    
    private void reverseInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        reverseInOrder(node.right);
        runningSum += node.val;
        node.val = runningSum;
        reverseInOrder(node.left);
    }
    
    public TreeNode convertBST(TreeNode root) {
        reverseInOrder(root);
        return root;
    }
}

