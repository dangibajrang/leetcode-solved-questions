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
//     public TreeNode invertTree(TreeNode root) {
//           if (root == null) return null; // If the tree is empty, return null.

//         Queue<TreeNode> queue = new LinkedList<>();
//          queue.add(root);

//         while (!queue.isEmpty()) {
//             TreeNode current = queue.poll(); // Dequeue a node.

//         // Swap the left and right children.
//             TreeNode temp = current.left;
//             current.left = current.right;
//             current.right = temp;

//         // Enqueue the left and right children to continue the process.
//              if (current.left != null) queue.add(current.left);
//              if (current.right != null) queue.add(current.right);
//         }

//         return root; // Return the root after inverting
//     }
// }


class Solution {

    // Method to invert the binary tree
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the node is null, return null (nothing to invert)
        if (root == null) {
            return null;
        }

        // Recursively invert the left subtree
        TreeNode leftInverted = invertTree(root.left);
        
        // Recursively invert the right subtree
        TreeNode rightInverted = invertTree(root.right);

        // Swap the left and right children of the current node
        root.left = rightInverted;
        root.right = leftInverted;

        // Return the current node after inverting
        return root;
    }

    public static void main(String[] args) {
        // Creating a sample tree:
        //        4
        //       / \
        //      2   7
        //     / \ / \
        //    1  3 6  9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Create an instance of the solution class
        Solution solution = new Solution();

        // Invert the binary tree
        TreeNode invertedRoot = solution.invertTree(root);

        // Print the root value after inversion (for demonstration purposes)
        System.out.println("Root of the inverted tree: " + invertedRoot.val);
    }
}


// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//          if (root == null)
//       return null;

//     TreeNode left = root.left;
//     TreeNode right = root.right;
//     root.left = invertTree(right);
//     root.right = invertTree(left);
//     return root;
//     }
// }