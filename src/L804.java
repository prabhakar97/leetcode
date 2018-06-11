import java.util.HashSet;
import java.util.Set;

class Solution804 {
    private static final String[] MORSE = new String[] { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.." };

    /**
     * 804. Unique Morse Code Words https://leetcode.com/problems/unique-morse-code-words/description/
     * @param words String[]
     *              The list of input words to be transformed to Morse
     * @timeComplexity O(n) where n is the number of chars in all words
     * @spaceComplexity O(n) where n is the number of chars in all unique transformations
     * @return The number of unique morse transformations
     */
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> transformations = new HashSet<>();
        for (String word : words) {
            StringBuffer sb = new StringBuffer();
            for (char c : word.toCharArray()) {
                sb.append(MORSE[c - 'a']);
            }
            transformations.add(sb.toString());
        }
        return transformations.size();

        // Alternate and slower one liner accepted solution
        // Arrays.asList(words).stream().map(word -> word.chars().mapToObj(c -> MORSE[c - 'a']).collect(Collectors.joining())).collect(Collectors.toSet()).size();*/
    }
}
