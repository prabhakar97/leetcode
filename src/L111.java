public class L111 {
    /**
     * 111. Minimum Depth of Binary Tree https://leetcode.com/problems/minimum-depth-of-binary-tree/
     *
     * @timeComplexity O(n)
     * @spaceComplexity O(1) ignoring stack space
     */
    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = minDepth(root.left);
            int rightHeight = minDepth(root.right);
            return 1 + (Math.min(leftHeight, rightHeight) > 0 ? Math.min(leftHeight, rightHeight) : Math.max(leftHeight, rightHeight));
        }
    }
}