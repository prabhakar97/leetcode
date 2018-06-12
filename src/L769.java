class Solution769 {
    /**
     * 769. Max Chunks To Make Sorted https://leetcode.com/problems/max-chunks-to-make-sorted/description/
     * Since the array contains elements in the range n - 1, we just count the number of boundaries before which max is
     * equal to i.
     * @timeComplexity O(n) Where n is the length of input array
     * @spaceComplexity O(1)
     * @param arr int[]
     *            The input array
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int max = Integer.MIN_VALUE;
        int chunks = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                chunks++;
                max = Integer.MIN_VALUE;
            }
        }
        return chunks;
    }
}
