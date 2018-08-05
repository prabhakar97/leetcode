class Solution121 {
    class Solution {
        /**
         * 121. Best Time to Buy and Sell Stock https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
         *
         * @param prices
         * @return Maximum profit that can be made
         * @timeComplexity O(n)
         * @spaceComplexity O(1)
         */
        public int maxProfit(int[] prices) {
            // At every point in the array, we maintain two values - maxProfit so far, and minimum price seen so far
            int maxProfit = 0;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; i++) {
                maxProfit = Math.max(maxProfit, prices[i] - minValue);
                minValue = Math.min(prices[i], minValue);
            }
            return maxProfit;
        }
    }
}