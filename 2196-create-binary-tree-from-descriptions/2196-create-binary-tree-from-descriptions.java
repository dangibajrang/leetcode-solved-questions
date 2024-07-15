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
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> valToNode = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int parentVal = d[0];
            int childVal = d[1];
            boolean isLeft = d[2] == 1;

            // Get or create the parent node
            TreeNode parentNode = valToNode.computeIfAbsent(parentVal, k -> new TreeNode(parentVal));

            // Get or create the child node
            TreeNode childNode = valToNode.computeIfAbsent(childVal, k -> new TreeNode(childVal));

            // Set the left or right child
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            // Mark this node as a child
            children.add(childVal);
        }

        // Find the root node (a node that is not a child)
        for (int parentVal : valToNode.keySet()) {
            if (!children.contains(parentVal)) {
                return valToNode.get(parentVal);
            }
        }

        return null; // Should never happen as there is always one root
    }

   
}
