class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int L =0 ,R =0;
        int min = Integer.MAX_VALUE, sum =0;
        int n = nums.length;

        while(R<n){
            sum += nums[R];

            while(target<=sum){
                min= Math.min(min,R-L+1);
                sum-= nums[L];
                L++;
            }
            R++;
        }
        return min == Integer.MAX_VALUE?0:min;
    }
}