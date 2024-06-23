//Time Complexity: O(n log n) for sorting + O(n) for partitioning = O(n log n)
//sorting the array first and then using a greedy algorithm to partition the array into the minimum number of subsets


class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array first
        int n = nums.length;
        int count = 0; // To count the number of subsets
        int i = 0; // Pointer to traverse the sorted array

        while (i < n) {
            count++; // Start a new subset
            int start = nums[i]; // The first element of the current subset
            // Move the pointer until the difference exceeds k
            while (i < n && nums[i] - start <= k) {
                i++;
            }
        }

        return count; // Return the number of subsets
    }
}
