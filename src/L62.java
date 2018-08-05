class Solution62 {
    class Solution {
        /**
         * 62. Unique Paths https://leetcode.com/problems/unique-paths/description/
         *
         * @param m Number of rows
         * @param n Number of columnes
         * @return Number of paths to end of grid
         * @timeComplexity O(m * n)
         * @spaceComplexity O(m * n)
         */
        public int uniquePaths(int m, int n) {
            int table[][] = new int[m][n];
            for (int i = 0; i < m; i++) {
                table[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                table[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    table[i][j] = table[i - 1][j] + table[i][j - 1];
                }
            }
            return table[m - 1][n - 1];
        }
    }
}

