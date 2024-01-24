// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int n= nums.length;
//         if(n< 3) return n;

//         int L=0,R=1,Counter=0;

//         while(R<n){
//             if(nums[L] != nums[R]){
//                 L++;
//                 nums[L] = nums[R];
//                 Counter =0;
//             }else if (nums[L] ==nums[R]  &&  Counter<1){
//                 Counter ++;
//                 nums[++L] =nums[R];
//             }
//             R++;
//         }
//         return L+1;
        
//     }
// }


class Solution {
  public int removeDuplicates(int[] nums) {
    int i = 0;

    for (final int num : nums)
      if (i < 2 || num > nums[i - 2])
        nums[i++] = num;

    return i;
  }
}