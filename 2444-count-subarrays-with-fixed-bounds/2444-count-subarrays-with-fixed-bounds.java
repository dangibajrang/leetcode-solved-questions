class Solution {
  public long countSubarrays(int[] nums, int minK, int maxK) {
    // Initialize the variable to store the count of subarrays
    long ans = 0;
    // Initialize variable j to track the index where the last element outside the range [minK, maxK] was found
    int j = -1;
    // Initialize variables to store the indices of the last occurrence of minK and maxK respectively
    int prevMinKIndex = -1;
    int prevMaxKIndex = -1;

    // Loop through each element in the nums array
    for (int i = 0; i < nums.length; ++i) {
      // Check if the current element is less than minK or greater than maxK
      if (nums[i] < minK || nums[i] > maxK)
        // If so, update j to the current index i, indicating the last element outside the range
        j = i;
      // Check if the current element is equal to minK
      if (nums[i] == minK)
        // If so, update prevMinKIndex to the current index i
        prevMinKIndex = i;
      // Check if the current element is equal to maxK
      if (nums[i] == maxK)
        // If so, update prevMaxKIndex to the current index i
        prevMaxKIndex = i;
      // Calculate the number of subarrays that satisfy the conditions
      // by taking the minimum of prevMinKIndex and prevMaxKIndex
      // and subtracting j + 1 (the start index of the subarray)
      ans += Math.max(0, Math.min(prevMinKIndex, prevMaxKIndex) - j);
    }

    // Return the total count of subarrays
    return ans;
  }
}















//tle

// class Solution {
//     public int countSubarrays(int[] nums, int minK, int maxK) {
//         int count = 0;
//         int n = nums.length;

//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 int min = Integer.MAX_VALUE;
//                 int max = Integer.MIN_VALUE;
//                 for (int k = i; k <= j; k++) {
//                     min = Math.min(min, nums[k]);
//                     max = Math.max(max, nums[k]);
//                 }
//                 if (min == minK && max == maxK) {
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }

    // public static void main(String[] args) {
    //     Solution solution = new Solution();
    //     int[] nums = {1, 3, 5, 2, 7, 5};
    //     int minK = 1;
    //     int maxK = 5;
    //     System.out.println(solution.countSubarrays(nums, minK, maxK)); // Output: 2
    // }
//}



//2. wrong answer
// class Solution {
//     public int countSubarrays(int[] nums, int minK, int maxK) {
//         int n = nums.length;
//         int count = 0;
//         int leftBound = -1;
//         int minPosition = -1;
//         int maxPosition = -1;

//         for (int i = 0; i < n; i++) {
//             if (nums[i] < minK || nums[i] > maxK) {
//                 leftBound = i; // Reset the left boundary
//             }
//             if (nums[i] == minK) {
//                 minPosition = i; // Update the position of the latest minK
//             }
//             if (nums[i] == maxK) {
//                 maxPosition = i; // Update the position of the latest maxK
//             }

//             // Count the number of valid subarrays ending at index i
//             if (minPosition != -1 && maxPosition != -1) {
//                 count += Math.max(0, Math.min(minPosition, maxPosition) - leftBound);
//             }
//         }

//         return count;
//     }

//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         int[] nums = {1, 3, 5, 2, 7, 5};
//         int minK = 1;
//         int maxK = 5;
//         System.out.println(solution.countSubarrays(nums, minK, maxK)); // Output: 2
//     }
// }

