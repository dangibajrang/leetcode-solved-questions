class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int gap = Integer.MAX_VALUE, ans =0 ,n = nums.length;

        for(int i = 0 ; i<n; i++){
            int L =i+1 , R =n-1;
            while(L<R){
                int curSum= nums[L] + nums[R] + nums[i];
                if(curSum == target){
                    return target;
                
                }else if(curSum< target){
                    L++;
                }else{
                    R--;
                }
                int curGap = Math.abs(curSum - target);

                if(curGap < gap){
                    gap =curGap;
                    ans =curSum;
                }
            }
        }
        return ans;
        
    }
}