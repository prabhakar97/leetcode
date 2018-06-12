import java.util.PriorityQueue;
import java.util.Queue;

class Solution767 {
    // We use this structure to store counts of occurences of each character
    class CharCount implements Comparable<CharCount> {
        char ch;
        int count;
        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(CharCount o) {
            return Integer.compare(o.count, this.count);
        }
    }

    /**
     * 767. Reorganize String https://leetcode.com/problems/reorganize-string/description/
     * @timeComplexity O(n) where n is the length of string
     * @spaceComplexity O(1) Constant amount of space in the priority queue (26 chars only)
     * @param S Input string
     * @return A permutation of S where none of the same chars are adjacent
     */
    public String reorganizeString(String S) {
        int[] counts = new int[26];
        for (char c : S.toCharArray()) {
            counts[c - 'a']++;
        }
        int maxRepeated = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 1) {
                maxRepeated = Math.max(maxRepeated, counts[i]);
            }
        }
        int threshold = (S.length() % 2 == 0 ? S.length() / 2 : S.length() / 2 + 1);
        // If the number of maxrepeated character is majority (> 50%), then we don't have a solution
        if (maxRepeated > threshold) {
            return "";
        } else {
            // Put the chars and their counts in priority queue
            Queue<CharCount> pq = new PriorityQueue<>();
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    pq.add(new CharCount((char) (i + 'a'), counts[i]));
                }
            }
            StringBuffer sb = new StringBuffer();
            char prev = 'A';
            while (!pq.isEmpty()) {
                // Extract max occuring character from queue
                CharCount cur = pq.remove();
                CharCount temp = null;
                if (cur.ch == prev) {
                    // We already used it, so take out another one to use
                    temp = cur;
                    cur = pq.remove();
                }
                sb.append(cur.ch);
                prev = cur.ch;
                // Add it back only if we have more of it
                if (cur.count > 1) {
                    cur.count--;
                    pq.add(cur);
                }
                // Put the old one back into queue if we took it out
                if (temp != null) {
                    pq.add(temp);
                }
            }
            return sb.toString();
        }
    }
}
