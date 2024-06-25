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

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
    
//     TreeNode(int x) {
//         val = x;
//     }
// }

// class Solution {
    
//     private int sumGreater(TreeNode root, int val) {
//         if (root == null) {
//             return 0;
//         }
//         int total = 0;
//         if (root.val > val) {
//             total += root.val;
//         }
//         total += sumGreater(root.left, val);
//         total += sumGreater(root.right, val);
//         return total;
//     }
    
//     public TreeNode bstToGst(TreeNode root) {
//         if (root == null) {
//             return null;
//         }
//         root.val += sumGreater(root, root.val);
//         bstToGst(root.left);
//         bstToGst(root.right);
//         return root;
//     }
// }


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
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
    
    public TreeNode bstToGst(TreeNode root) {
        reverseInOrder(root);
        return root;
    }
}
