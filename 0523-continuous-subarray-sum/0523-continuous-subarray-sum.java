import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    int currentSum = 0; // This will keep track of the cumulative sum of the elements.
    Map<Integer, Integer> sumRemainderMap = new HashMap<>();
    sumRemainderMap.put(0, -1); // Initialize with 0 remainder at index -1 for edge cases.

    for (int i = 0; i < nums.length; ++i) {
      currentSum += nums[i]; // Add the current element to the cumulative sum.

      // If k is not zero, take the remainder of the current sum divided by k.
      if (k != 0) {
        currentSum %= k;
      }

      // Check if this remainder has been seen before.
      if (sumRemainderMap.containsKey(currentSum)) {
        // Check if the subarray length is at least 2.
        if (i - sumRemainderMap.get(currentSum) > 1) {
          return true; // We found a valid subarray.
        }
      } else {
        // Store the first occurrence of this remainder.
        sumRemainderMap.put(currentSum, i);
      }
    }

    return false; // No valid subarray found.
  }
}
