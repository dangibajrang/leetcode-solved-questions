import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int minOperations(int[] nums, int x) {
    // Calculate the target sum which is the total sum of the array minus x
    final int targetSum = Arrays.stream(nums).sum() - x;
    
    // If the target sum is 0, it means we need to remove all elements to get x
    if (targetSum == 0) {
      return nums.length;
    }

    // Find the length of the longest subarray with sum equal to targetSum
    final int maxLen = findMaxSubArrayLen(nums, targetSum);
    
    // If no such subarray exists, return -1
    // Otherwise, the result is the total length minus the length of the longest subarray
    return maxLen == -1 ? -1 : nums.length - maxLen;
  }

  // Helper method to find the maximum length of subarray with sum equal to k
  private int findMaxSubArrayLen(int[] nums, int k) {
    int maxLength = -1; // Initialize maxLength to -1, meaning no subarray found initially
    int currentPrefixSum = 0; // This will store the current prefix sum
    Map<Integer, Integer> prefixSumIndexMap = new HashMap<>(); // Map to store the first occurrence of each prefix sum
    prefixSumIndexMap.put(0, -1); // Initialize the map with prefix sum 0 at index -1

    // Iterate through each number in the input array
    for (int i = 0; i < nums.length; ++i) {
      currentPrefixSum += nums[i]; // Update the current prefix sum
      
      // Calculate the target prefix sum we need to find
      final int targetPrefixSum = currentPrefixSum - k;
      
      // Check if the target prefix sum has been seen before
      if (prefixSumIndexMap.containsKey(targetPrefixSum)) {
        // Update maxLength if we found a longer subarray
        maxLength = Math.max(maxLength, i - prefixSumIndexMap.get(targetPrefixSum));
      }
      
      // Store the current prefix sum and its index in the map if it's not already present
      prefixSumIndexMap.putIfAbsent(currentPrefixSum, i);
    }

    return maxLength; // Return the length of the longest subarray found
  }
}
