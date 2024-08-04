class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1_000_000_007;

        // Min-heap to store the subarray sums
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Generate the initial heap elements
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{nums[i], i, i});
        }

        long result = 0;
        for (int k = 1; k <= right; k++) {
            int[] curr = minHeap.poll();
            if (k >= left) {
                result = (result + curr[0]) % mod;
            }
            if (curr[2] + 1 < n) {
                minHeap.offer(new int[]{curr[0] + nums[curr[2] + 1], curr[1], curr[2] + 1});
            }
        }

        return (int) result;
    }
}
