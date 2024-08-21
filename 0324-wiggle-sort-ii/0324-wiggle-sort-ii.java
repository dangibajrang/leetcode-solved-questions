

public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;               // Get the length of the array
        
        // Create a copy of the original array and sort it
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        // Calculate the midpoint of the sorted array
        int mid = (n + 1) / 2;             // The midpoint index (for odd and even cases)
        int left = mid - 1;               // Pointer to the end of the first half (smallest elements)
        int right = n - 1;                // Pointer to the end of the second half (largest elements)

        // Fill the original array with elements from the sorted array in wiggle order
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[left--]; // Place from the end of the first half
            } else {
                nums[i] = sorted[right--]; // Place from the end of the second half
            }
        }
    }
}
