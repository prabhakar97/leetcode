import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L103 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> curList = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode cur = q.remove();
                if (cur == null) {
                    if (q.isEmpty()) {
                        break;
                    }
                    // Sentinel encountered, level ends
                    q.add(cur);
                    result.add(curList);
                    curList = new ArrayList<>();
                    continue;
                }
                curList.add(cur.val);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}
