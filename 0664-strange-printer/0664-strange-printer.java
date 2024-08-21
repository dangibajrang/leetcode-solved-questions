class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        // if (n == 0) return 0;

        int[][] dp = new int[n][n];

        // Base case: single character substrings
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the dp array
        for (int length = 2; length <= n; length++) { // length of the substring
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1; // endpoint of the substring
                dp[i][j] = length; // maximum turns would be the length itself (worst case)

                // Iterate over all possible splits
                for (int k = i; k < j; k++) {
                    int totalTurns = dp[i][k] + dp[k + 1][j];
                    if (s.charAt(i) == s.charAt(j)) {
                        totalTurns--; // merge the turns if the first and last characters are the same
                    }
                    dp[i][j] = Math.min(dp[i][j], totalTurns);
                }
            }
        }

        // The answer is the minimum turns needed to print the entire string
        return dp[0][n - 1];
    }
}
