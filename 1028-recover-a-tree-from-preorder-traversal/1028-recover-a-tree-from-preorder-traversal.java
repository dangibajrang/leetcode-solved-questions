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
    
    public TreeNode recoverFromPreorder(String traversal) {
        // Stack to keep track of nodes at different depths
        Deque<TreeNode> stack = new ArrayDeque<>();
        int index = 0; // Pointer to traverse the string
        
        // Loop through the string to reconstruct the tree
        while (index < traversal.length()) {
            int level = 0; // Depth of the current node
            
            // Count the number of dashes to determine the depth
            while (index < traversal.length() && traversal.charAt(index) == '-') {
                level++;
                index++;
            }
            
            // Extract the node value from the string
            int value = 0;
            while (index < traversal.length() && Character.isDigit(traversal.charAt(index))) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }
            
            // Create the new node
            TreeNode node = new TreeNode(value);
            
            // If the stack size is greater than the level, pop elements to reach the correct parent
            while (stack.size() > level) {
                stack.pop();
            }
            
            // Attach the new node as either a left or right child
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node; // Assign as left child if available
                } else {
                    parent.right = node; // Otherwise, assign as right child
                }
            }
            
            // Push the current node to the stack
            stack.push(node);
        }
        
        // The root node is at the bottom of the stack
        while (stack.size() > 1) {
            stack.pop();
        }
        
        return stack.pop(); // Return the root of the reconstructed tree
    }
    
    // Utility function to print the tree in preorder (for testing)
    public void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

}
