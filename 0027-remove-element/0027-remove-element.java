public class Solution {
    public int removeElement(int[] nums, int val) {
        // Initialize the pointer for the position to place non-val elements
        int newIndex = 0;

        // Iterate through the array using a pointer
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not the value to remove
            if (nums[i] != val) {
                // Place it at the new index and increment the new index
                nums[newIndex] = nums[i];
                newIndex++;
            }
        }

        // Return the length of the array with the specified value removed
        return newIndex;
    }
}
