//1:brute force TLE

// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         int count = 0;
//         for (int start = 0; start < nums.length; start++) {
//             int oddCount = 0;
//             for (int end = start; end < nums.length; end++) {
//                 if (nums[end] % 2 != 0) {
//                     oddCount++;
//                 }
//                 if (oddCount == k) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

//  reduces the time complexity from 
// \U0001d442
// (
// \U0001d45b
// 2
// )
// O(n 
// 2
//  ) to 
// \U0001d442
// (
// \U0001d45b
// )
// O(n)
//2: optimized using sliding window technique
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int oddCount = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        
        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
            if (prefixMap.containsKey(oddCount - k)) {
                count += prefixMap.get(oddCount - k);
            }
            prefixMap.put(oddCount, prefixMap.getOrDefault(oddCount, 0) + 1);
        }
        
        return count;
    }
}
