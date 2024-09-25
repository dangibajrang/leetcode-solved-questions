class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    int minLength = Integer.MAX_VALUE;
    int left = 0, sum = 0;
    
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right]; // Expand window
        
        while (sum >= target) { // Shrink window
            minLength = Math.min(minLength, right - left + 1);
            sum -= nums[left];
            left++;
        }
    }
    
    return (minLength != Integer.MAX_VALUE) ? minLength : 0;
}

  

}