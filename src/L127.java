import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class L127 {
    /**
     * 127. Word Ladder https://leetcode.com/problems/word-ladder/
     *
     * @timeComplexity n chars in word and N max transformation length in dictionary 26^n * N
     * @spaceComplexity O(N)
     */

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<>(wordList);
            Map<String, Integer> levels = new HashMap<>();
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            levels.put(beginWord, 1);
            while (!queue.isEmpty()) {
                String cur = queue.poll();
                // For each index in the string change char at that index and check if it is in dict
                // If yes, add it to the queue
                for (int i = 0; i < cur.length(); i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == cur.charAt(i)) {
                            continue;
                        }
                        StringBuffer neighbour = new StringBuffer();
                        if (i > 0) {
                            neighbour.append(cur.substring(0, i));
                        }
                        neighbour.append(j);
                        if (i < cur.length()) {
                            neighbour.append(cur.substring(i + 1));
                        }
                        if (!dict.contains(neighbour.toString()) || levels.containsKey(neighbour.toString())) {
                            continue;
                        }
                        if (endWord.equals(neighbour.toString())) {
                            return levels.get(cur) + 1;
                        }
                        queue.add(neighbour.toString());
                        levels.put(neighbour.toString(), levels.get(cur) + 1);
                    }
                }
            }
            return 0;
        }
    }
}
