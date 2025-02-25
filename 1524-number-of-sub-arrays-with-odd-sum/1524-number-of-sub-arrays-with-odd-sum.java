class Solution {
    public int numOfSubarrays(int[] arr) {
        // Modulo value to prevent integer overflow
        final int MOD = 1_000_000_007;
        
        // Running prefix sum
        int sum = 0;
        
        // Count of subarrays with odd sum
        int result = 0;
        
        // Count of prefix sums that are even and odd
        int oddCount = 0, evenCount = 1; // Start with evenCount = 1 (for subarrays starting at index 0)

        // Iterate through the array
        for (int num : arr) {
            // Update prefix sum
            sum += num;
            
            // If prefix sum is odd, it forms an odd subarray with even prefixes
            if (sum % 2 != 0) {
                result = (result + evenCount) % MOD; // Odd sum can be formed by subtracting even sum
                oddCount++; // Increment odd prefix count
            } else {
                result = (result + oddCount) % MOD; // Even sum - odd sum gives odd sum
                evenCount++; // Increment even prefix count
            }
        }

        // Return the final count of subarrays with odd sum
        return result;
    }
}
