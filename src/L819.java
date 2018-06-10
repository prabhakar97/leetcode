import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Solution819 {
    /**
     * 819. Most Common Word https://leetcode.com/problems/most-common-word/description/
     * @timeComplexity O(n) where n is the length of string
     * @spaceComplexity max(O(k), O(l)) where k is the number of unique words in the string, l is the list of banned words
     * @param paragraph String
     *          Paragraph to scan.
     * @param banned String[]
     *          List of banned words
     * @return int[] containing distances
     */
    private static final String PUNCTUATIONS = ",.!?';";

    // Predicate to check whether a word ends with punctuation symbol
    private static final Predicate<String> puncChecker = (str) -> PUNCTUATIONS.chars().anyMatch(p -> str.charAt(str.length() - 1) == p);

    public String mostCommonWord(String paragraph, String[] banned) {
        // Populate a set of banned words
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned).stream().map(String::toLowerCase).collect(Collectors.toList()));
        Map<String, Integer> countMap = new HashMap<>();

        String[] words = paragraph.toLowerCase().split(" ");
        // Scan words and update their frequencies in map
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Remove last char if word ends with punctuation
            if (puncChecker.test(word)) {
                word = word.substring(0, word.length() - 1);
            }
            if (bannedSet.contains(word)) {
                continue;
            }
            if (countMap.containsKey(word)) {
                countMap.put(word, countMap.get(word) + 1);
            } else {
                countMap.put(word, 1);
            }
        }
        int max = 0;
        String maxWord = "";
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxWord = entry.getKey();
            }
        }
        return maxWord;
    }
}
