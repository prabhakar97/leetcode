class Solution72 {
    class Solution {
        /**
         * 72. Edit Distance https://leetcode.com/problems/edit-distance/description/
         *
         * @param word1 First word
         * @param word2 Second word
         * @return Levenshtein distance
         * @timeComplexity O(m * n)
         * @spaceComplexity (O ( m * n)
         */
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            if (m == 0) {
                return n;
            } else if (n == 0) {
                return m;
            }
            int[][] table = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                table[i][0] = i;
            }
            for (int i = 1; i <= n; i++) {
                table[0][i] = i;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int insert = table[i - 1][j] + 1;
                    int delete = table[i][j - 1] + 1;
                    int replace = table[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                    table[i][j] = Math.min(insert, delete);
                    table[i][j] = Math.min(table[i][j], replace);
                }
            }
            return table[m][n];
        }
    }
}
