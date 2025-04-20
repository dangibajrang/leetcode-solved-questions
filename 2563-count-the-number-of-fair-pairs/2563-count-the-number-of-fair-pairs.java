class Solution {

    // Function to count fair pairs.
    public long countFairPairs(int[] nums, int lower, int upper) {

        // First, sort the array to allow binary search logic.
        Arrays.sort(nums);

        // Initialize variable to store the total count of fair pairs.
        long count = 0;

        // Loop over each number in the array using index i.
        for (int i = 0; i < nums.length; i++) {

            // For the current nums[i], find the lower bound index.
            int leftIndex = lowerBound(nums, i + 1, nums.length - 1, lower - nums[i]);

            // For the current nums[i], find the upper bound index.
            int rightIndex = upperBound(nums, i + 1, nums.length - 1, upper - nums[i]);

            // Add the count of valid pairs between leftIndex and rightIndex.
            count += (rightIndex - leftIndex + 1);
        }

        // Return the final count of fair pairs.
        return count;
    }

    // Helper method to find the smallest index where nums[index] >= target.
    private int lowerBound(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2; // Calculate middle index.
            if (nums[mid] < target) {  // If mid element is less than target.
                start = mid + 1;       // Move to the right half.
            } else {
                end = mid - 1;         // Move to the left half.
            }
        }
        return start; // Return the left-most valid index.
    }

    // Helper method to find the largest index where nums[index] <= target.
    private int upperBound(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2; // Calculate middle index.
            if (nums[mid] <= target) { // If mid element is less than or equal to target.
                start = mid + 1;       // Move to the right half.
            } else {
                end = mid - 1;         // Move to the left half.
            }
        }
        return end; // Return the right-most valid index.
    }

}
