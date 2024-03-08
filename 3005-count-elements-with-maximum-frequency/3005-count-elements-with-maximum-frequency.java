class Solution {
  // Function to calculate the maximum frequency elements in an array
  public int maxFrequencyElements(int[] nums) {
    // Constant representing the maximum value in the array
    final int kMax = 100;
    // Variable to store the final result
    int ans = 0;
    // Array to store the count of each element in the range [0, kMax]
    int[] count = new int[kMax + 1];

    // Count the occurrences of each element in the array
    for (final int num : nums)
      ++count[num];

    // Find the maximum frequency in the 'count' array
    final int maxFreq = Arrays.stream(count).max().getAsInt();

    // Iterate through the frequency count array and calculate the final answer
    for (final int freq : count)
      if (freq == maxFreq)
        ans += maxFreq;

    // Return the final result
    return ans;
  }
}
