class Solution {
    public int maxProfit(int k, int[] prices) {
        // If the prices array is empty, return 0 as no profit can be made.
        if (prices.length == 0) return 0;
        
        int n = prices.length; // Length of the prices array.
        
        // If the number of transactions (k) is larger than or equal to half the number of days,
        // it is equivalent to having unlimited transactions.
        // This is because you can buy and sell on every increase in price.
        if (k >= n / 2) {
            int maxProfit = 0;
            // Iterate through the prices array.
            for (int i = 1; i < n; i++) {
                // If the price on the current day is greater than the previous day,
                // add the difference to the maxProfit (this simulates buying on the previous day and selling on the current day).
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            // Return the total profit for unlimited transactions.
            return maxProfit;
        }
        
        // Initialize a 2D DP array where dp[j][i] represents the maximum profit
        // achievable by the i-th day with at most j transactions.
        int[][] dp = new int[k + 1][n];
        
        // Iterate over the number of transactions from 1 to k.
        for (int j = 1; j <= k; j++) {
            // Initialize a variable to keep track of the maximum difference
            // between the previous day's dp value and the price on that day.
            int maxDiff = -prices[0];
            // Iterate over the days starting from day 1.
            for (int i = 1; i < n; i++) {
                // Update the dp[j][i] with the maximum profit that can be made by either:
                // - Not selling the stock on the i-th day (dp[j][i - 1]), or
                // - Selling the stock on the i-th day (prices[i] + maxDiff).
                dp[j][i] = Math.max(dp[j][i - 1], prices[i] + maxDiff);
                // Update maxDiff to be the maximum of itself and the difference between
                // the previous transaction's profit and the current day's price.
                // This helps in determining the best day to buy for the next transaction.
                maxDiff = Math.max(maxDiff, dp[j - 1][i] - prices[i]);
            }
        }
        
        // The answer will be the maximum profit achievable with k transactions by the last day.
        return dp[k][n - 1];
    }
}
