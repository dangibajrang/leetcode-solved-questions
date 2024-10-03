class Solution {
    public int minSubarray(int[] nums, int p) {
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Calculate the remainder of the total sum modulo p
        int remainder = totalSum % p;
        
        // If the remainder is 0, the total sum is already divisible by p
        if (remainder == 0) {
            return 0; // No need to remove any subarray
        }
        
        // HashMap to store the prefix sums and their mod p values
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        // Initialize the map with 0 -> -1 to handle cases where the prefix sum itself can form the solution
        prefixSumMap.put(0, -1);
        
        // Variables to track the current prefix sum and the minimum length of the subarray to remove
        int prefixSum = 0;
        int minLength = nums.length;
        
        // Iterate through the array to find the subarray
        for (int i = 0; i < nums.length; i++) {
            // Update the prefix sum
            prefixSum += nums[i];
            
            // Calculate current prefix sum's mod p value
            int currentMod = prefixSum % p;
            
            // Find the target mod value needed to remove the subarray and make the remaining sum divisible by p
            int targetMod = (currentMod - remainder + p) % p;
            
            // Check if the target mod value is present in the map
            if (prefixSumMap.containsKey(targetMod)) {
                // If found, update the minimum length
                minLength = Math.min(minLength, i - prefixSumMap.get(targetMod));
            }
            
            // Add current prefix sum mod value to the map
            prefixSumMap.put(currentMod, i);
        }
        
        // If no valid subarray is found, return -1, otherwise return the minimum length
        return minLength == nums.length ? -1 : minLength;
    }
}
