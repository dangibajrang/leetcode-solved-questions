class Solution {
    public int countHillValley(int[] nums) {
         // Initialize a variable 'ans' to count the number of hills or valleys.
    int ans = 0;
    // Initialize a variable 'left' with the first element of the input array 'nums'.
    int left = nums[0];

    // Iterate through the elements of the array 'nums' starting from the second element up to the second-to-last element.
    for (int i = 1; i + 1 < nums.length; ++i) {
      // Check if the current element is part of a hill or a valley.
      if (left < nums[i] && nums[i] > nums[i + 1] ||
          left > nums[i] && nums[i] < nums[i + 1]) {
        // If the condition is true, it indicates the presence of a hill or valley.
        // Increment 'ans' by 1 and update the value of 'left' to the current element 'nums[i]'.
        ++ans;
        left = nums[i];
      }
    }

    // Return the total count of hills and valleys.
    return ans;
        
    }
}