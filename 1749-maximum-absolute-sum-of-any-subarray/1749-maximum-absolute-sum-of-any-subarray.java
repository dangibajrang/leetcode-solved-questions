class Solution {
    public int maxAbsoluteSum(int[] nums) {
        // Variable to keep track of the maximum subarray sum
        int maxSum = 0;
        // Variable to keep track of the minimum subarray sum
        int minSum = 0;
        // Variable to store the final result (maximum absolute sum)
        int result = 0;
        
        // Iterate through the array
        for (int num : nums) {
            // Update maxSum using Kadane's Algorithm for maximum subarray sum
            maxSum = Math.max(0, maxSum + num);
            // Update minSum using Kadane's Algorithm for minimum subarray sum
            minSum = Math.min(0, minSum + num);
            
            // Update result with the maximum absolute value between maxSum and minSum
            result = Math.max(result, Math.max(maxSum, -minSum));
        }
        
        // Return the maximum absolute sum of any subarray
        return result;
    }
}
