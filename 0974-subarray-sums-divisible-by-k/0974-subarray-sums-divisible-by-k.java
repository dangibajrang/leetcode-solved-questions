class Solution {
  public int subarraysDivByK(int[] nums, int k) {
    int totalSubarrays = 0; // This will store the total number of subarrays divisible by k
    int currentPrefixSum = 0; // This will store the current prefix sum
    int[] prefixRemainderCount = new int[k]; // Array to store counts of remainders when prefix sums are divided by k
    prefixRemainderCount[0] = 1; // There's one way to have a prefix sum with remainder 0

    // Iterate through each number in the input array
    for (int num : nums) {
      // Update the current prefix sum and take modulo k to handle large sums
      currentPrefixSum = (currentPrefixSum + num % k + k) % k;
      // If there are previous prefix sums with the same remainder, it means we found a subarray
      totalSubarrays += prefixRemainderCount[currentPrefixSum];
      // Increment the count of this remainder for future subarray checks
      prefixRemainderCount[currentPrefixSum]++;
    }

    return totalSubarrays; // Return the total number of subarrays found
  }
}
