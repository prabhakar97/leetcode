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
                if (map.get(s.charAt(curEnd)) != null) {
                    int newStart = map.get(s.charAt(curEnd)) + 1;
                    // Remove all keys from curStart until newStart
                    for (int j = curStart; j < newStart; j++) {
                        map.remove(s.charAt(j));
                    }
                    curStart = newStart;
                }
                map.put(s.charAt(curEnd), curEnd);
                maxSeen = Math.max(maxSeen, curEnd - curStart + 1);
                curEnd++;
            }
            return maxSeen;
        }
    }
}
