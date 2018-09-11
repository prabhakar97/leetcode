import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class L103 {
    /**
     * 103. Binary Tree Zigzag Level Order Traversal https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
     *
     * @timeComplexity O(n)
     * @spaceComplexity O(n)
     */
    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Map<Integer, List<Integer>> result = new HashMap<>();
            Map<TreeNode, Integer> levels = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            levels.put(root, 0);
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                if (current == null) {
                    continue;
                }
                int currentLevel = levels.get(current);
                if (!result.containsKey(currentLevel)) {
                    result.put(currentLevel, new ArrayList<>());
                }
                result.get(currentLevel).add(current.val);
                queue.add(current.left);
                queue.add(current.right);
                levels.put(current.left, currentLevel + 1);
                levels.put(current.right, currentLevel + 1);
            }
            return result.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).map(x -> {
                if (x.getKey() % 2 == 0) {
                    return x.getValue();
                } else {
                    List<Integer> temp = x.getValue().subList(0, x.getValue().size());
                    Collections.reverse(temp);
                    return temp;
                }
            }).collect(Collectors.toList());
        }
    }
}
