import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution791 {
    /**
     * 791. Custom Sort String https://leetcode.com/problems/custom-sort-string/description/
     * @timeComplexity O(n log n) Where n is the length of String T
     * @spaceComplexity O(1)
     * @param S String
     *          A string representing order of characters for sorting
     * @param T String
     *          Input string to sort based on given order
     * @return Final result string
     */
    public String customSortString(String S, String T) {
        List<Character> chars = T.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        // We create a new comparator and sort the input string based on this comparator
        Collections.sort(chars, Comparator.comparingInt(c -> S.indexOf(c)));
        return chars.stream().map(String::valueOf).collect(Collectors.joining());
    }

}
