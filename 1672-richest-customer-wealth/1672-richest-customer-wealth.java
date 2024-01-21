class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for(int[] person : accounts){
            int sum = 0;
            for(int wealth : person){
                sum+=wealth;
            }
            if(sum>ans){
                ans =sum;
            }
        }
        return ans;
    }
}