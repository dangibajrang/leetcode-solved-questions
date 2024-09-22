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


 //using dfs
// class Solution {
//     private TreeNode parentX = null;
//     private TreeNode parentY = null;
//     private int depthX = -1;
//     private int depthY = -1;

//     public boolean isCousins(TreeNode root, int x, int y) {
//         if (root == null) {
//             return false;
//         }

//         // Start DFS to find the nodes
//         dfs(root, null, x, y, 0);

//         // Check if both nodes have the same depth and different parents
//         return depthX == depthY && parentX != parentY;
//     }

//     private void dfs(TreeNode node, TreeNode parent, int x, int y, int depth) {
//         if (node == null) {
//             return;
//         }

//         // Check if the current node is x or y
//         if (node.val == x) {
//             parentX = parent;
//             depthX = depth;
//         } else if (node.val == y) {
//             parentY = parent;
//             depthY = depth;
//         }

//         // Continue DFS on left and right children
//         dfs(node.left, node, x, y, depth + 1);
//         dfs(node.right, node, x, y, depth + 1);
//     }

//     public static void main(String[] args) {
//         // Create a sample binary tree:
//         //        1
//         //       / \
//         //      2   3
//         //     / \   \
//         //    4   5   6
//         //   /
//         //  7

//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(2);
//         root.right = new TreeNode(3);
//         root.left.left = new TreeNode(4);
//         root.left.right = new TreeNode(5);
//         root.right.right = new TreeNode(6);
//         root.left.left.left = new TreeNode(7);

//         Solution solution = new Solution();
//         boolean result = solution.isCousins(root, 4, 6);  // Output: false
//         System.out.println(result);
        
//         result = solution.isCousins(root, 5, 6);  // Output: true
//         System.out.println(result);
//     }
// }









//using bfs level order traversal


        class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // Initialize the flags to check if x and y are found
        boolean foundX = false;
        boolean foundY = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            foundX = false;
            foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                // Check if current node is x or y
                if (currentNode.val == x) {
                    foundX = true;
                }
                if (currentNode.val == y) {
                    foundY = true;
                }

                // Check if x and y are siblings (same parent)
                if (currentNode.left != null && currentNode.right != null) {
                    if ((currentNode.left.val == x && currentNode.right.val == y) ||
                        (currentNode.left.val == y && currentNode.right.val == x)) {
                        return false; // They share the same parent
                    }
                }

                // Enqueue left and right children for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // If both nodes are found at the same level, they are cousins
            if (foundX && foundY) {
                return true;
            }
        }

        // If we exit the loop, they are not cousins
        return false;
    }

    public static void main(String[] args) {
        // Create a sample binary tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        //   /
        //  7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        Solution solution = new Solution();
        boolean result1 = solution.isCousins(root, 4, 6);  // Output: false
        System.out.println(result1);

        boolean result2 = solution.isCousins(root, 5, 6);  // Output: true
        System.out.println(result2);
    }
}

