import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution763 {
    /**
     * 763. Partition Labels https://leetcode.com/problems/partition-labels/description/
     * @timeComplexity O(n)
     * @spaceComplexity O(1) Constant space needed for lastIndexMap
     * @param S Input string
     * @return Number of partitions
     */
    public List<Integer> partitionLabels(String S) {
        // Store the last index in string at which a character can be seen
        int[] lastIndexMap = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            lastIndexMap[chars[i] - 'a'] = i;
        }

        List<Integer> partitionSizes = new ArrayList<>();
        int currentPartitionSize = 0;
        int maxIndexSeenSoFar = 0;
        for (int i = 0; i < chars.length; i++) {
            // What is the largest index that a char can be found, across all chars seen so far
            maxIndexSeenSoFar = Math.max(maxIndexSeenSoFar, lastIndexMap[chars[i] - 'a']);
            currentPartitionSize++;
            // Can we close a partition here?
            if (maxIndexSeenSoFar <= i) {
                partitionSizes.add(currentPartitionSize);
                currentPartitionSize = 0;
            }
        }
        return partitionSizes;

    }
}
