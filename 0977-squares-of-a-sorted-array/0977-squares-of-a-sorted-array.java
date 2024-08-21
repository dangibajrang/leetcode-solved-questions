public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;        // Pointer to the start of the array
        int right = n - 1;   // Pointer to the end of the array
        int pos = n - 1;     // Position in the result array (starting from the end)

        // Traverse the array from both ends
        while (left <= right) {
            // Calculate squares of elements at both ends
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            // Place the larger square at the current position in the result array
            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                left++;    // Move left pointer to the right
            } else {
                result[pos] = rightSquare;
                right--;   // Move right pointer to the left
            }
            pos--;    // Move to the next position in the result array
        }
        
        return result;    // Return the sorted squares array
    }
}
