import java.util.Arrays;

class Solution764 {
    /**
     * 764. Largest Plus Sign https://leetcode.com/problems/largest-plus-sign/description/
     * @timeComplexity O(N^2)
     * @spaceComplexity O(N^2)
     * @param N int
     *          Size of the input grid
     * @param mines int[][]
     *              Location of mines in the input grid
     * @return Size of biggest +
     */
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        // Create the input grid and populate with 1s
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], 1);
        }

        // Place mines
        for (int i = 0; i < mines.length; i++) {
            grid[mines[i][0]][mines[i][1]] = 0;
        }

        // Aux array for caching best plus hand size seen at any cell
        int[][] aux = new int[N][N];
        int streak = 0;
        for (int i = 0; i < N; i++) {
            // Move left to right and update the aux with size of streak of 1s seen so far
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    streak++;
                } else {
                    streak = 0;
                }
                aux[i][j] = streak;
            }
            // Move right to left and update the aux with min of size of streak from left and size from right
            streak = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    streak++;
                } else {
                    streak = 0;
                }
                aux[i][j] = Math.min(aux[i][j], streak);
            }
            streak = 0;
        }
        for (int i = 0; i < N; i++) {
            // Move top to bottom and update the aux with min of size of streak in dp and current
            streak = 0;
            for (int j = 0; j < N; j++) {
                if (grid[j][i] == 1) {
                    streak++;
                } else {
                    streak = 0;
                }
                aux[j][i] = Math.min(aux[j][i], streak);
            }
            // Move from bottom to top and update the aux as earlier
            streak = 0;
            for (int j = N - 1; j >=0; j--) {
                if (grid[j][i] == 1) {
                    streak++;
                } else {
                    streak = 0;
                }
                aux[j][i] = Math.min(aux[j][i], streak);
            }
        }
        // Return the longest streak
        int maxPlus = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxPlus = Math.max(maxPlus, aux[i][j]);
            }
        }
        return maxPlus;
    }
}
