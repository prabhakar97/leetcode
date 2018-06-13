class Solution64 {
    /**
     * 64. Minimum Path Sum https://leetcode.com/problems/minimum-path-sum/description/
     * @timeComplexity O(m*n)
     * @spaceComplexity O(m*n)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] table = new int[m][n];
        int sum = 0;
        // For each position in the first row, store the cumulative sum
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            table[0][i] = sum;
        }
        sum = 0;
        // For each position in the first column, store the cumulative sum
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            table[i][0] = sum;
        }
        // Choose the best path out of the top and left
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                table[i][j] = grid[i][j] + Math.min(table[i-1][j], table[i][j-1]);
            }
        }
        return table[m-1][n-1];
    }
}
