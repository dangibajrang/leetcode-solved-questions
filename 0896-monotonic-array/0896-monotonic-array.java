class Solution {
  public boolean isMonotonic(int[] nums) {
    // Initialize two boolean variables to track monotonicity
    boolean increasing = true;
    boolean decreasing = true;

    // Iterate through the array starting from the second element
    for (int i = 1; i < nums.length; ++i) {
      // Check if the array is non-decreasing
      increasing &= nums[i] >= nums[i - 1];
      
      // Check if the array is non-increasing
      decreasing &= nums[i] <= nums[i - 1];
    }

    // Return true if either increasing or decreasing monotonicity is satisfied
    return increasing || decreasing;
  }
}
