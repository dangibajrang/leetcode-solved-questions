class Solution {
    public boolean isArraySpecial(int[] nums) {
        
           // Step 1: Iterate through the array elements
        for (int i = 1; i < nums.length; i++) {
            // Step 2: Check if two consecutive elements have the same parity
            if ((nums[i] % 2) == (nums[i - 1] % 2)) {
                // Step 3: If two consecutive numbers are both even or both odd, return false
                return false;
            }
        }
        // Step 4: If all adjacent elements alternate correctly, return true
        return true;
    }
}