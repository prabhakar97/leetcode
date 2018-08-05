import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution830 {
    class Solution {
        /**
         * 830. Positions of Large Groups https://leetcode.com/problems/positions-of-large-groups/description/
         *
         * @param S String
         *          Input string.
         * @return List of large group positions
         * @timeComplexity O(n) where n is the number of characters in String
         * @spaceComplexity O(1). The declared result list is for output, it is not auxiliary.
         */
        public List<List<Integer>> largeGroupPositions(String S) {
            final List<List<Integer>> result = new ArrayList<>();
            char prev = 0;
            int curLen = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == prev) {
                    curLen++;
                } else {
                    // We process pevious group
                    if (curLen >= 3) {
                        result.add(Arrays.asList(i - curLen, i - 1));
                    }
                    // We end previous group and begin a new one
                    curLen = 1;
                }
                prev = S.charAt(i);
            }
            // Do this if we hit the end of string and a current sequence is going on
            if (curLen >= 3) {
                result.add(Arrays.asList(S.length() - curLen, S.length() - 1));
            }
            return result;
        }
    }
}