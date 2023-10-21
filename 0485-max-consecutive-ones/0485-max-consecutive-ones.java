class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen =0,counter=0;

        for(int num:nums){
            if(num == 0){
                counter =0;
            }else{
                counter++;
                maxLen=Math.max(maxLen,counter);
            }
        }
        return maxLen;
    }
}