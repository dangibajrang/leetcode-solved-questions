class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] suffixSum = new int[n];
        
        // Build the suffix sum array
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }
        
        return helper(0, 1, piles, dp, suffixSum);
    }
    
    private int helper(int i, int M, int[] piles, int[][] dp, int[] suffixSum) {
        if (i == piles.length) return 0;
        if (2 * M >= piles.length - i) return suffixSum[i];
        if (dp[i][M] != 0) return dp[i][M];
        
        int minOpponent = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M; x++) {
            minOpponent = Math.min(minOpponent, helper(i + x, Math.max(M, x), piles, dp, suffixSum));
        }
        
        dp[i][M] = suffixSum[i] - minOpponent;
        return dp[i][M];
    }
}
