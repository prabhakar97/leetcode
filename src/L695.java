class Solution695 {
    class Solution {
        class Value {
            public int value;
        }

        /**
         * 695. Max Area of Island https://leetcode.com/problems/max-area-of-island/description/
         *
         * @param grid int[][]
         *             The input grid
         * @return Area of maximum grid
         * @timeComplexity O(m * n)
         * @spaceComplexity O(m * n) because we are mutating seen cells
         */
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        Value v = new Value();
                        flood(grid, i, j, v);
                        max = Math.max(max, v.value);
                    }
                }
            }
            return max;
        }

        private void flood(int[][] grid, int i, int j, Value v) {
            if (grid[i][j] == 1) {
                // Mark flooded
                grid[i][j] = '0';
                v.value = v.value + 1;
                if (i > 0) {
                    flood(grid, i - 1, j, v);
                }
                if (i < grid.length - 1) {
                    flood(grid, i + 1, j, v);
                }
                if (j > 0) {
                    flood(grid, i, j - 1, v);
                }
                if (j < grid[0].length - 1) {
                    flood(grid, i, j + 1, v);
                }
            }
        }
    }
}
