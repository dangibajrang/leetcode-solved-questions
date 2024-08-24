/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

 
    // Serializes a binary tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    // Helper function to perform pre-order traversal and serialize the tree.
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,"); // Append # for null nodes.
            return;
        }
        sb.append(node.val).append(","); // Append the node value.
        serializeHelper(node.left, sb);  // Recursively serialize the left subtree.
        serializeHelper(node.right, sb); // Recursively serialize the right subtree.
    }

    // Deserializes a string back to a binary tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    // Helper function to construct the tree from the serialized data.
    private TreeNode deserializeHelper(Queue<String> nodes) {
        String value = nodes.poll();
        if (value.equals("#")) return null; // Return null for # markers.
        TreeNode node = new TreeNode(Integer.parseInt(value)); // Create a new node.
        node.left = deserializeHelper(nodes); // Recursively build the left subtree.
        node.right = deserializeHelper(nodes); // Recursively build the right subtree.
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));