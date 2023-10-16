class Solution {
    public void sortColors(int[] nums) {
       int n =nums.length;
        int L =0 , R = n-1, cur = 0;

        while(cur<=R){
            if(nums[cur] == 2){
                swap(nums,cur,R);
                R--;
            }else if(nums[cur] == 1){
                cur++;
            }else{
                swap(nums,cur,L);
                L++;
                cur++;

            }
        }
    }
    private void swap(int[] nums , int p1 ,int p2){
        int temp =nums[p1];
        nums[p1] = nums[p2];
        nums[p2] =temp;
    }
}