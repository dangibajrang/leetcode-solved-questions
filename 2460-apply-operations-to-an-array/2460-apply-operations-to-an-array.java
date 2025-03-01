class Solution {
    public int[] applyOperations(int[] nums) {
        // Step 1: Apply the transformation rule
        for (int i = 0; i < nums.length - 1; i++) {
            // If two consecutive numbers are equal, double the first and set the second to zero
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2; // Double the value
                nums[i + 1] = 0; // Set the next number to zero
            }
        }

        // Step 2: Move all non-zero elements to the left
        int index = 0; // Pointer to place non-zero elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i]; // Move non-zero element to the correct position
            }
        }

        // Step 3: Fill the remaining positions with zeroes
        while (index < nums.length) {
            nums[index++] = 0; // Fill remaining positions with zero
        }

        return nums; // Return the modified array
    }

}
