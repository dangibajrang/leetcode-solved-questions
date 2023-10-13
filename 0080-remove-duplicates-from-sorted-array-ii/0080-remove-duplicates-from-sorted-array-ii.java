class Solution {
    public int removeDuplicates(int[] nums) {
        int n= nums.length;
        if(n< 3) return n;

        int L=0,R=1,Counter=0;

        while(R<n){
            if(nums[L] != nums[R]){
                L++;
                nums[L] = nums[R];
                Counter =0;
            }else if (nums[L] ==nums[R]  &&  Counter<1){
                Counter ++;
                nums[++L] =nums[R];
            }
            R++;
        }
        return L+1;
        
    }
}