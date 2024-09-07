class Solution {
    public int maxSubArray(int[] nums) {
        int bestsum = Integer.MIN_VALUE;
        int cursum = 0 ;
        for(int  i = 0; i <nums.length; i++){
            cursum = Math.max(nums[i], cursum+nums[i]);
            bestsum = Math.max(cursum ,bestsum);

        }
        return bestsum;
    }
}