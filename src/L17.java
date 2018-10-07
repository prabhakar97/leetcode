import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17 {
    /**
     * 17. Letter Combinations of a Phone Number https://leetcode.com/problems/letter-combinations-of-a-phone-number/
     *
     * @timeComplexity O(n) (each digit makes 3 or 4 function calls)
     * @spaceComplexity O(1)
     */
    static class Solution {
        private static final Map<Character, List<Character>> config = new HashMap<Character, List<Character>>() {{
            put('2', Arrays.asList('a', 'b', 'c'));
            put('3', Arrays.asList('d', 'e', 'f'));
            put('4', Arrays.asList('g', 'h', 'i'));
            put('5', Arrays.asList('j', 'k', 'l'));
            put('6', Arrays.asList('m', 'n', 'o'));
            put('7', Arrays.asList('p', 'q', 'r', 's'));
            put('8', Arrays.asList('t', 'u', 'v'));
            put('9', Arrays.asList('w', 'x', 'y', 'z'));
        }};

        public List<String> letterCombinations(String digits) {
            List<String> results = new ArrayList<>();
            solve(digits, "", results, 0);
            return results;
        }

        private void solve(String digits, String current, List<String> results, int curpos) {
            if (curpos == digits.length()) {
                results.add(current);
                return;
            } else {
                config.get(digits.charAt(curpos)).forEach(c -> solve(digits, current + c, results, curpos + 1));
            }
        }
    }
}
