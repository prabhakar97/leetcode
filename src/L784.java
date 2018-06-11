import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution784 {
    /**
     * 784. Letter Case Permutation https://leetcode.com/problems/letter-case-permutation/description/
     * @timeComplexity O(2^n) where n is the number of chars in input string
     * @spaceComplexity O(2^n) Where n is the number of chars in input string
     * @param S String
     *          Input string
     * @return List of strings
     */
    public List<String> letterCasePermutation(String S) {
        Set<String> resultSet = new HashSet<>();
        permuteTree(S, "", 0, resultSet);
        return resultSet.stream().collect(Collectors.toList());
    }

    private void permuteTree(String s, String currentPrefix, int currentIndex, Set<String> result) {
        if (currentIndex >= s.length()) {
            result.add(currentPrefix);
            return;
        }
        if (s.charAt(currentIndex) <= '9') {
            // Do nothing
        } else if (s.charAt(currentIndex) <= 'Z') {
            permuteTree(s, currentPrefix +  (char) (s.charAt(currentIndex) + ('a' - 'A')), currentIndex + 1, result);
        } else {
            permuteTree(s, currentPrefix +  (char) (s.charAt(currentIndex) - ('a' - 'A')), currentIndex + 1, result);
        }
        permuteTree(s, currentPrefix + s.charAt(currentIndex), currentIndex + 1, result);
    }
}
