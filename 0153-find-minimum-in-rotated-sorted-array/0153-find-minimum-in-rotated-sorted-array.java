class Solution {
    public int findMin(int[] nums) {
        int L =0,R=nums.length-1;
        if(nums[L] < nums[R]) return nums[L];

        while(L+1<R){
            int mid =L+(R-L)/2;

            if(nums[mid]>nums[R]){
                L= mid;
            }else{
                R=mid;
            }
        }
        return Math.min(nums[L], nums[R]);
    }
}