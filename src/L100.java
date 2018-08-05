class Solution100 {
    class Solution {
        /**
         * 100. Same Tree https://leetcode.com/problems/same-tree/description/
         * @timeComplexity O(n)
         * @spaceComplexity O(1) ignoring recursion stack space
         * @param p Root of the tree 1
         * @param q Root of the tree 2
         * @return Whether trees are structurally same
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
