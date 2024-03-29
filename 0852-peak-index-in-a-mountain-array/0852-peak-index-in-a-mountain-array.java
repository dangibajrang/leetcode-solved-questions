class Solution {
    public int peakIndexInMountainArray(int[] arr) {
         int left = 0, n = arr.length, right = n - 1;
        //Base case
        if(n == 1) return left;
        
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] > arr[mid + 1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
        
    }
}

// class Solution {
//     public int findPeakElement(int[] nums) {
//         int left = 0, n = nums.length, right = n - 1;
//         //Base case
//         if(n == 1) return left;
        
//         while(left < right){
//             int mid = (left + right) / 2;
//             if(nums[mid] > nums[mid + 1]){
//                 right = mid;
//             }else{
//                 left = mid + 1;
//             }
//         }
//         return left;
//     }
// }