class Solution122 {
    /**
     * 122. Best Time to Buy and Sell Stock II https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     * @timeComplexity O(n)
     * @sapceComplexity O(1)
     * @param prices
     * @return Max profit obtainable
     */
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int minInPart = Integer.MAX_VALUE;
        int maxInPart = Integer.MIN_VALUE;
        // We find all the partitions of the array such that first number is least and last number is max in the partition
        // A transaction is buying in first day of partition and selling on second day. All such partitions may not be
        // constitute full array
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minInPart) {
                minInPart = prices[i];
                // Reset the max in partition because maxInPartition must come after min in partition
                maxInPart = Integer.MIN_VALUE;
            }
            maxInPart = Math.max(maxInPart, prices[i]);
            // Condition for a transaction to execute. If it is end of array, execute anyway else execute
            // if this is partition boundary
            if (minInPart < maxInPart && (i == prices.length - 1 || prices[i] > prices[i+1])) {
                totalProfit += maxInPart - minInPart;
                minInPart = Integer.MAX_VALUE;
                maxInPart = Integer.MIN_VALUE;
            }
        }
        return totalProfit;
    }
}