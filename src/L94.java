import java.util.ArrayList;
import java.util.List;

class Solution94 {
    class Solution {
        /**
         * 94. Binary Tree Inorder Traversal https://leetcode.com/problems/binary-tree-inorder-traversal/description/
         * @timeComplexity O(n)
         * @spaceComplexity O(1) ignoring stack space
         * @param root Root of the binary tree
         * @return List containing inorder traversed elements
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorderHelper(root, result);
            return result;
        }

        private void inorderHelper(TreeNode root, List<Integer> values) {
            if (root == null) {
                return;
            }
            inorderHelper(root.left, values);
            values.add(root.val);
            inorderHelper(root.right, values);
        }
    }
}
