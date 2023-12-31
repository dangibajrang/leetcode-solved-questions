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
    List<Integer> res = new LinkedList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        //base case
        if(root == null) return;
        
        //traverse the left side
        dfs(root.left);
        
        //take the current node val
        res.add(root.val);
        
        //traverse the right side
        dfs(root.right);
    }
}