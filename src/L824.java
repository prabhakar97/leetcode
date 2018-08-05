import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution824 {
    class Solution {
        /**
         * 824: Goat Latin https://leetcode.com/problems/goat-latin/description/
         * This solution leverages Java 8's stream features.
         *
         * @param S String
         *          Input string
         * @return Goat latin string
         * @timeComplexity O(n) where n is the number of characters in input string. There are constant number of vowels
         * in line 20 to be iterated.
         * @spaceComplexity O(1) the string buffer is only for output, it is not auxiliary.
         */
        public String toGoatLatin(String S) {
            String[] splits = S.split(" ");
            return String.join(" ", IntStream.range(0, splits.length).mapToObj(i -> {
                StringBuffer sb = new StringBuffer();
                // Its a vowel
                if ("aeiouAEIOU".chars().anyMatch(c -> c == splits[i].charAt(0))) {
                    sb.append(splits[i]);
                    // Its a consonant
                } else {
                    sb.append(splits[i].substring(1));
                    sb.append(splits[i].charAt(0));
                }
                sb.append("maa");
                for (int j = 0; j < i; j++) {
                    sb.append('a');
                }
                return sb.toString();
            }).collect(Collectors.toList()));
        }
    }
}