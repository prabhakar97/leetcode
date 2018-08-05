import java.util.LinkedList;
import java.util.Queue;

class Solution785 {
    class Solution {
        /**
         * 785. Is Graph Bipartite? https://leetcode.com/problems/is-graph-bipartite/description/
         *
         * @param graph
         * @return
         * @timeComplexity O(V + E)
         * @spaceComplexity O(V)
         */
        public boolean isBipartite(int[][] graph) {
            if (graph.length == 0) {
                return true;
            }
            int[] color = new int[graph.length];    // 0 uncolored 1 RED 2 BLUE
            for (int i = 0; i < graph.length; i++) {    // In case we have islands
                if (color[i] != 0) {
                    continue;
                }
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;   // Color red
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == color[node]) {
                            return false;
                        } else if (color[neighbor] == 0) {
                            color[neighbor] = ((color[node] - 1) ^ 1) + 1;  // 1 -> 2 and 2 -> 1
                            queue.add(neighbor);
                        }
                    }
                }
            }
            return true;
        }
    }
}
