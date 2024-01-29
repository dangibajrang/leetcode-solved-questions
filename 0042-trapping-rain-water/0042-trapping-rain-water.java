// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;
//         int max = 0 ;
//         int maxIndex = 0;
//         int totalwater = 0;

//         for (int i =0 ; i <n ; i++){
//             if(height[i] > max){
//                 max = height[i];
//                 maxIndex = i;
//             }
//         }
//         int leftMax = 0;
//         for(int i =0 ; i<maxIndex ;i++){
//             leftMax= Math.max(leftMax , height[i]);
//             int water = Math.min(leftMax , max )-height[i];
//             totalwater += water;
//         }
//          leftMax = 0;
//         for(int i = n-1 ; i>maxIndex ; i--){
//             leftMax =Math.max(leftMax , height[i]);
//             int water = Math.min(leftMax , max) - height[i];
//             totalwater += water;
//         }
//         return totalwater;
        
//     }
// }


class Solution {
  public int trap(int[] height) {
    if (height.length == 0)
      return 0;

    int ans = 0;
    int l = 0;
    int r = height.length - 1;
    int maxL = height[l];
    int maxR = height[r];

    while (l < r)
      if (maxL < maxR) {
        ans += maxL - height[l];
        maxL = Math.max(maxL, height[++l]);
      } else {
        ans += maxR - height[r];
        maxR = Math.max(maxR, height[--r]);
      }

    return ans;
  }
}