class Solution771 {
    /**
     * 771. Jewels and Stones https://leetcode.com/problems/jewels-and-stones/description/
     * @timeComplexity O(max(j, s)) where j is number of jewels and s is number of stones
     * @spaceComplexity O(1) Using a boolean array of fixed size i.e. 52
     * @param J Jewel string
     * @param S Stone string
     * @return Number of stones which are jewels
     */
    public int numJewelsInStones(String J, String S) {
        boolean[] isJewel = new boolean[52];
        for (char c : J.toCharArray()) {
            if (c <= 'Z') {
                // We record whether a capital letter is jewel from 0-25
                isJewel[c - 'A'] = true;
            } else if (c <= 'z') {
                // We record whether a small letter is jewel from 26-51
                isJewel[c - 'a' + 26] = true;
            }
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c <= 'Z') {
                if (isJewel[c - 'A']) {
                    count++;
                }
            } else if (c <= 'z') {
                if (isJewel[c - 'a' + 26]) {
                    count++;
                }
            }
        }
        return count;
    }
}
