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
                lineCount++;
                curLine = widths[S.charAt(i) - 'a'];
            } else if (curLine == 100) {
                lineCount++;
                curLine = 0;
            }
        }
        int[] result = new int[2];
        result[0] = lineCount;
        result[1] = curLine;
        return result;
    }
}
