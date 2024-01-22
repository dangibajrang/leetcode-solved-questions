// class Solution {
//     public int findDuplicate(int[] nums) {
//         for(int i =0 ; i<nums.length ;i++){
//             int index = Math.abs(nums[i]);
//             if(nums[index]<0) return index;
//             nums [index] = -nums[index];

//         }
//         return -1;
        
//     }
// }

class Solution {
    public int findDuplicate(int[] nums) {
    HashSet<Integer> seen = new HashSet<>();
    for (int num : nums) {
        if (seen.contains(num)) {
            return num;
        }
        seen.add(num);
    }
    return -1;  // Just to satisfy the compiler, this should never be reached
}
}