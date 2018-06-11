class Solution783 {

    private int minDiff = Integer.MAX_VALUE;
    private TreeNode previous;

    /**
     * 783. Minimum Distance Between BST Nodes https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
     * Inorder traversal of a BST processes the nodes in sorted order. We maintain the previously seen element while traversing
     * and compare with min seen so far to keep track of the min difference.
     * @timeComplexity O(n) where n is the number of nodes in tree
     * @spaceComplexity O(1)
     * @param root TreeNode
     *             Root of the tree
     * @return Min difference between any two nodes
     */
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return minDiff;
        }
        // Traverse left
        minDiffInBST(root.left);

        // Traverse root
        if (previous != null) {
            minDiff = Math.min(minDiff, root.val - previous.val);
        }
        previous = root;

        // Traverse right
        minDiffInBST(root.right);

        return minDiff;
    }

}
