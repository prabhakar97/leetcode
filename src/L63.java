class Solution63 {
    class Solution {
        /**
         * 63. Unique Paths II https://leetcode.com/problems/unique-paths-ii/description/
         *
         * @param obstacleGrid
         * @return Number of unique paths from top left to bottom right
         * @timeComplexity O(m * n)
         * @spaceComplexity O(m * n)
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int table[][] = new int[m][n];
            boolean obstacleFound = false;
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] == 0 && !obstacleFound) {
                    table[i][0] = 1;
                } else {
                    obstacleFound = true;
                    table[i][0] = 0;
                }
            }
            obstacleFound = false;
            for (int i = 0; i < n; i++) {
                if (obstacleGrid[0][i] == 0 && !obstacleFound) {
                    table[0][i] = 1;
                } else {
                    obstacleFound = true;
                    table[0][i] = 0;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 0) {
                        table[i][j] = table[i - 1][j] + table[i][j - 1];
                    }
                }
            }
            return table[m - 1][n - 1];

        }
    }
}
