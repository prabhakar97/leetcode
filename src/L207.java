import java.util.ArrayList;
import java.util.List;

class Solution207 {
    class Solution {
        int[] visited;  // 0 unvisited 1 visiting 2 visited

        /**
         * 207. Course Schedule https://leetcode.com/problems/course-schedule/description/
         *
         * @param numCourses
         * @param prerequisites
         * @return
         * @timeComplexity O(V + E)
         * @spaceComplexity O(V)
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0) {
                return true;
            }
            visited = new int[numCourses];
            List<List<Integer>> graph = new ArrayList<>();
            // Initialize graph
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }
            // Populate graph
            for (int i = 0; i < prerequisites.length; i++) {
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 2) {
                    continue;
                }
                if (hasCycle(graph, i)) {
                    return false;
                }
            }
            return true;
        }

        public boolean hasCycle(List<List<Integer>> graph, int src) {
            List<Integer> destinations = graph.get(src);
            for (int dest : destinations) {
                if (visited[dest] == 2) {
                    continue;
                }
                // Its a cycle!
                if (visited[dest] == 1) {
                    return true;
                }
                visited[dest] = 1;
                if (hasCycle(graph, dest)) {
                    return true;
                }
                visited[dest] = 2;
            }
            return false;
        }
    }
}
