class Solution799 {
    class Solution {
        /**
         * 799. Champagne Tower https://leetcode.com/problems/champagne-tower/description/
         *
         * @param poured      Amount of liquid poured
         * @param query_row   Row number to query
         * @param query_glass Glass number to query
         * @return Amount of liquid getting poured
         * @timeComplexity O(m * n) where m is the number of rows and n is the number of queried glass
         * @spaceComplexity O(m * n) where m is the number of rows and n is the number of queried glass
         */
        public double champagneTower(int poured, int query_row, int query_glass) {
            // Assume f(i, j) is the amount of champagne (contribution) received by ith row jth glass, then
            // f(0, 0) = poured
            // c(i-1, j) is contribution from right glass on top, which is (f(i-1, j) - 1) / 2 if it is > 1.0 else 0.0
            // c(i-1, j-1) is contribution from left glass on top, which is (f(i-1, j-1) - 1) / 2 if it is > 1.0 else 0.0
            // f(i, j) =  c(i-1, j) if j == 0 // First glass in the row only has contribution from first in previous row (right one)
            //            c(i-1, j-1) if j == i // Last glass in the row only has contribution from last in previous row (left one)
            //            otherwise c(i-1, j-1) + c(i-1, j)
            //
            double[][] table = new double[query_row + 1][query_glass + 1];
            table[0][0] = poured;
            for (int i = 1; i <= query_row; i++) {
                for (int j = 0; j <= query_glass; j++) {
                    if (i == j) {
                        // Last glass in the row only has contribution from last in previous row
                        table[i][j] = (table[i - 1][j - 1] > 1.0) ? (table[i - 1][j - 1] - 1.0) / 2 : 0.0;
                    } else if (j == 0) {
                        // First glass in the row only has contribution from first in previous row
                        table[i][j] = (table[i - 1][j] > 1.0) ? (table[i - 1][j] - 1.0) / 2 : 0.0;
                    } else {
                        // Contribution from two above ones
                        table[i][j] = ((table[i - 1][j - 1] > 1.0) ? (table[i - 1][j - 1] - 1.0) / 2 : 0.0) + ((table[i - 1][j] > 1.0) ? (table[i - 1][j] - 1.0) / 2 : 0.0);
                    }
                }
                if (table[i - 1][(i - 1) / 2] == 0) {
                    // No need to process any further. Everything ahead is 0.0
                    break;
                }
            }
            if (table[query_row][query_glass] >= 1.0) {
                // If we received more than a cup, then we let the extra spillover to bottom
                return 1.0;
            } else {
                return table[query_row][query_glass];
            }
        }
    }
}
