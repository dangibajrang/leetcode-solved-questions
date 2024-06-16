class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1; // smallest number that cannot be formed
        int patches = 0; // count of patches added
        int i = 0; // index of nums array
        
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i]; // extend the range
                i++;
            } else {
                miss += miss; // add miss itself as a patch
                patches++;
            }
        }
        
        return patches;
    }
}