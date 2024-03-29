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
//     public List<Integer> preorderTraversal(TreeNode root) {
//           List<Integer> res = new LinkedList<>();
//         if(root == null) return res;
//         Stack<TreeNode> stack = new Stack<>();

//        stack.add(root);

//         while(stack.isEmpty() == false){
//             TreeNode top = stack.pop();
//             //add the current node 
//             res.add(top.val);
//             if(top.right != null){
//                 //ensure that right is at the bottom of the left
//                 stack.add(top.right);
//             }
//             if(top.left != null){
//                 //ensure that left is on the top
//                 stack.add(top.left);
//             }
//         }
//         return res;
        
//     }
// }



// recursive
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    preorder(root, ans);
    return ans;
  }

  private void preorder(TreeNode root, List<Integer> ans) {
    if (root == null)
      return;

    ans.add(root.val);
    preorder(root.left, ans);
    preorder(root.right, ans);
  }
}