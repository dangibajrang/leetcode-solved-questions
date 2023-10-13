class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<2) return n;

        int L =0 ,R= 1;

        while(R< n){
            if(nums[L] != nums[R]){
                L++;
                nums[L] = nums[R];
            } 
            R++;
        }
        return L+1;
        
    }
}