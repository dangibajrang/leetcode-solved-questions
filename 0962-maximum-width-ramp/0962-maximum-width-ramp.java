class Solution {
    public int maxWidthRamp(int[] nums) {
        // Step 1: Create an array of index-value pairs
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }

        // Step 2: Sort the indices based on the values in nums
        Arrays.sort(indices, Comparator.comparingInt(i -> nums[i]));

        // Step 3: Traverse the sorted indices to calculate the maximum ramp width
        int maxRamp = 0;
        int minIndex = indices[0]; // Initialize the minimum index
        
        for (int i = 1; i < indices.length; i++) {
            // Calculate the width of the ramp
            maxRamp = Math.max(maxRamp, indices[i] - minIndex);
            // Update the minimum index
            minIndex = Math.min(minIndex, indices[i]);
        }

        return maxRamp;
    }
}
