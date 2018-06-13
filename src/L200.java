class Solution200 {
    /**
     * 200. Number of Islands https://leetcode.com/problems/number-of-islands/description/
     * @timeComplexity O(m * n) Each position is examined once
     * @spaceComplexity O(m * n) We mutate the input grid, proportional to number of ones.
     * @param grid Input character matrix
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    flood(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void flood(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            // Mark flooded
            grid[i][j] = '0';
            if (i > 0) {
                flood(grid, i - 1, j);
            }
            if (i < grid.length - 1) {
                flood(grid, i + 1, j);
            }
            if (j > 0) {
                flood(grid, i, j - 1);
            }
            if (j < grid[0].length - 1) {
                flood(grid, i, j  + 1);
            }
        }
    }
}
