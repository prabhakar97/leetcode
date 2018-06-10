class Solution806 {
    /**
     * 806. Number of Lines To Write String https://leetcode.com/problems/number-of-lines-to-write-string/description/
     * @timeComplexity O(n) where n is the number of characters in input string
     * @spaceComplexity O(1)
     * @param widths int[]
     *          Array of widths for each character at corresponding index
     * @param S String
     *          The input string
     * @return Two sized array with first element containing number of lines and second width of last line
     */
    public int[] numberOfLines(int[] widths, String S) {
        int lineCount = 1;
        int curLine = 0;
        for (int i = 0; i < S.length(); i++) {
            curLine += widths[S.charAt(i) - 'a'];
            if (curLine > 100) {
                // Didn't fit on current line
                lineCount++;
                // Spillover width
                curLine = widths[S.charAt(i) - 'a'];
            } else if (curLine == 100) {
                // Begin new line
                lineCount++;
                curLine = 0;
            }
        }
        return new int[] { lineCount, curLine };
    }
}
