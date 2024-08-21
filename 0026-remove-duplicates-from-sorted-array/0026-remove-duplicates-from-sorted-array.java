public class Solution {
    public int removeDuplicates(int[] nums) {
        // Initialize the left pointer to track the position for unique elements
        int left = 0;

        // Iterate through the array using the right pointer
        for (int right = 0; right < nums.length; right++) {
            // Check if the current element is different from the last unique element
            if (nums[left] != nums[right]) {
                // Move the left pointer forward to place the next unique element
                left++;

                // Update the position at the left pointer with the current unique element
                nums[left] = nums[right];
            }
        }

        // Return the length of the array with unique elements
        // `left + 1` because `left` is the index of the last unique element
        return left + 1;
    }
}
