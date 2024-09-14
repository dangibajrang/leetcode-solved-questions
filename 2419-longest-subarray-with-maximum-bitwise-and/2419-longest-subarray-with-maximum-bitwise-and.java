class Solution {
    public int longestSubarray(int[] nums) {
    int maxVal = 0, maxLen = 0, currentLen = 0;
    
    // Find the maximum value in the array
    for (int num : nums) {
        maxVal = Math.max(maxVal, num);
    }
    
    // Find the longest subarray where elements equal maxVal
    for (int num : nums) {
        if (num == maxVal) {
            currentLen++;
            maxLen = Math.max(maxLen, currentLen);
        } else {
            currentLen = 0;
        }
    }
    
    return maxLen;
    }

}