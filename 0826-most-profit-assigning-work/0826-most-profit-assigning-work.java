//brute force 
//Steps:
//1.For each worker, iterate over each job.
//2.Check if the worker can complete the job (worker ability >= job difficulty).
//3.Track the highest profit job the worker can complete.

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int totalProfit = 0;

        for (int w : worker) {
            int maxProfit = 0;
            for (int i = 0; i < difficulty.length; i++) {
                if (w >= difficulty[i]) {
                    maxProfit = Math.max(maxProfit, profit[i]);
                }
            }
            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}
