class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // Number of jobs
        int n = startTime.length;

        // Combine all job information into a single array
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i]; // Start time of job
            jobs[i][1] = endTime[i];   // End time of job
            jobs[i][2] = profit[i];    // Profit of job
        }

        // Sort jobs by their end time
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        // Array to store maximum profit at each job
        int[] dp = new int[n];

        // Initialize the first job's profit
        dp[0] = jobs[0][2];

        // Iterate through all jobs
        for (int i = 1; i < n; i++) {
            // Include the current job's profit
            int includeProfit = jobs[i][2];

            // Find the last non-conflicting job using binary search
            int lastNonConflict = binarySearch(jobs, i);

            // Add the profit of the last non-conflicting job if it exists
            if (lastNonConflict != -1) {
                includeProfit += dp[lastNonConflict];
            }

            // Store the maximum profit by including or excluding the current job
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        // Return the maximum profit obtainable
        return dp[n - 1];
    }

    // Helper method to find the last non-conflicting job using binary search
    private int binarySearch(int[][] jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if the job at mid ends before the current job starts
            if (jobs[mid][1] <= jobs[index][0]) {
                // Move to the right to find the closest non-conflicting job
                if (jobs[mid + 1][1] <= jobs[index][0]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                // Move to the left
                high = mid - 1;
            }
        }
        // Return -1 if no non-conflicting job is found
        return -1;
    }
}
