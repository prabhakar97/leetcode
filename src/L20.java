import java.util.HashMap;
import java.util.Map;

public class L20 {
    /**
     * 20. Valid Parentheses https://leetcode.com/problems/valid-parentheses/
     *
     * @timeComplexity O(n)
     * @spaceComplexity O(1) ignoring recursion stack
     */
    static class Solution {
        private static final Map<Character, Character> closing = new HashMap<Character, Character>() {{
            put('{', '}');
            put('(', ')');
            put('[', ']');
        }};

        public boolean isValid(String s) {
            if (s.equals("")) {
                return true;
            }
            int closingIndex = findClosingIndex(s.charAt(0), s);
            if (closingIndex == -1)
                return false;
            else
                return isValid(s.substring(1, closingIndex)) && isValid(s.substring(closingIndex + 1));
        }

        private int findClosingIndex(char c, String s) {
            if (s.charAt(0) != '(' && s.charAt(0) != '{' && s.charAt(0) != '[')
                return -1;
            int bal = 1;    // Balance keeps track of opening braces seen so far
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == c)
                    bal++;
                else if (s.charAt(i) == closing.get(c))
                    bal--;
                if (bal == 0)
                    return i;
            }
            return -1;
        }
    }

}
