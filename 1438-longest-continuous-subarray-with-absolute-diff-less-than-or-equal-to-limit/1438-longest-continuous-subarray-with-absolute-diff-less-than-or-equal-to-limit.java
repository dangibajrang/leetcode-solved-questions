//brute force tle
// class Solution {
//     public int longestSubarray(int[] nums, int limit) {
//         int n = nums.length;
//         int maxLength = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 int minVal = Integer.MAX_VALUE;
//                 int maxVal = Integer.MIN_VALUE;
//                 for (int k = i; k <= j; k++) {
//                     minVal = Math.min(minVal, nums[k]);
//                     maxVal = Math.max(maxVal, nums[k]);
//                 }
//                 if (maxVal - minVal <= limit) {
//                     maxLength = Math.max(maxLength, j - i + 1);
//                 }
//             }
//         }

//         return maxLength;
//     }
// }

//optimized using a sliding window technique along with two deques 
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
