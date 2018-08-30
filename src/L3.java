import java.util.HashMap;
import java.util.Map;

public class L3 {
    /**
     * 3. Longest Substring Without Repeating Characters https://leetcode.com/problems/longest-substring-without-repeating-characters/
     *
     * @timeComplexity O(n)
     * @spaceComplexity O(n)
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int maxSeen = 0;
            int curStart = 0;
            int curEnd = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (curEnd < s.length()) {
                if (map.get(s.charAt(curEnd)) == null) {
                    map.put(s.charAt(curEnd), curEnd);
                } else {
                    curStart = map.get(s.charAt(curEnd)) + 1;
                    map = new HashMap<>();
                    for (int j= curStart; j <= curEnd; j++) {
                        map.put(s.charAt(j), j);
                    }
                }
                maxSeen = Math.max(maxSeen, curEnd - curStart + 1);
                curEnd++;
            }
            return maxSeen;
        }
    }
}
