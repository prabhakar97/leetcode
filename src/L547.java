class Solution547 {
    class Solution {

        int[] rep;  // Representative
        int[] size; // Size of set with current member

        /**
         * 547. Friend Circles https://leetcode.com/problems/friend-circles/description/
         *
         * @param M
         * @return
         * @timeComplexity O(n * log n) in union find operations
         * @spaceComplexity O(n)
         */
        public int findCircleNum(int[][] M) {
            if (M.length <= 1) {
                return M.length;
            }
            // Init union find
            rep = new int[M.length];
            size = new int[M.length];
            for (int i = 0; i < M.length; i++) {
                rep[i] = i;
                size[i] = 1;
            }
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M.length; j++) {
                    if (M[i][j] == 1) {
                        union(i, j);
                    }
                }
            }

            // Count unique reps
            int[] uniq = new int[M.length];
            int result = 0;
            for (int i = 0; i < M.length; i++) {
                int repI = find(i);
                if (uniq[repI] == 0) {
                    result++;
                    uniq[repI] = 1;
                }
            }
            return result;
        }

        // Finds the representative of x
        private int find(int x) {
            while (x != rep[x]) {
                x = rep[x];
            }
            return x;
        }

        // Unites sets that contain x and y
        private void union(int x, int y) {
            int repX = find(x);
            int repY = find(y);
            if (size[repX] > size[repY]) {
                size[repX] += size[repY];
                rep[repY] = repX;
            } else {
                size[repY] += size[repX];
                rep[repX] = repY;
            }
        }
    }
}
