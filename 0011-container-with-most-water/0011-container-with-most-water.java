class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int L =0 , R =n-1,maxArea=Integer.MIN_VALUE;

        while(L<R){
            int area = (R-L)*Math.min(height[R],height[L]);
            maxArea = Math.max(maxArea,area);

            if(height[L]<height[R]){
                L++;
            }else{
                R--;
            }
        }
        return maxArea;
        
    }
}