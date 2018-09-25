public class L297 {
    /**
     * 297. Serialize and Deserialize Binary Tree https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
     *
     * @timeComplexity O(n)
     * @spaceComplexity O(n)
     */
    static class Codec {
        int readIndex = 0;
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuffer sb) {
            if (root == null) {
                sb.append('#');
            } else {
                sb.append(root.val);
            }
            sb.append(' ');
            if (root != null) {
                serialize(root.left, sb);
                serialize(root.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deserialize(data.split(" "));
        }
        private TreeNode deserialize(String[] input) {
            if (input[readIndex].equals("#")) {
                readIndex++;
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(input[readIndex++]));
            root.left = deserialize(input);
            root.right = deserialize(input);
            return root;
        }
    }
}
