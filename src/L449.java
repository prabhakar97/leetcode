import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class L449 {
    /**
     * 449. Serialize and Deserialize BST https://leetcode.com/problems/serialize-and-deserialize-bst/
     *
     * @timeComplexity O(n) serialize O(n) deserialize
     * @spaceComplexity O(n) for output On) for deserialize
     */

    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            traversePreorder(root, sb);
            return sb.toString();
        }
        public void traversePreorder(TreeNode root, StringBuilder sb) {
            if (root != null) {
                sb.append(String.valueOf(root.val));
                sb.append(" ");
                traversePreorder(root.left, sb);
                traversePreorder(root.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // Empty string gives a null tree
            if (data.length() == 0) {
                return null;
            }
            List<Integer> preorder = Arrays.stream(data.split(" ")).map(x -> Integer.valueOf(x)).collect(Collectors.toList());
            Stack<TreeNode> s = new Stack<>();
            TreeNode root = new TreeNode(preorder.get(0));
            s.push(root);
            for (int i = 1; i < preorder.size(); i++) {
                TreeNode temp = null;
                while (!s.isEmpty() && preorder.get(i) > s.peek().val)
                    temp = s.pop();
                if (temp != null) {
                    temp.right = new TreeNode(preorder.get(i));
                    s.push(temp.right);
                } else {
                    s.peek().left = new TreeNode(preorder.get(i));
                    s.push(s.peek().left);
                }
            }
            return root;
        }

    }
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
