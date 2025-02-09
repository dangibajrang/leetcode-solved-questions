class Solution {
    public long countBadPairs(int[] nums) {
        // HashMap to store frequency of (i - nums[i])
        HashMap<Integer, Long> freqMap = new HashMap<>();
        long goodPairs = 0;
        int n = nums.length;
        
        // Iterate over the array
        for (int i = 0; i < n; i++) {
            // Compute the transformed difference
            int diff = i - nums[i];

            // If diff exists in the map, add its count to goodPairs
            if (freqMap.containsKey(diff)) {
                goodPairs += freqMap.get(diff);
            }

            // Update the frequency of diff in the map
            freqMap.put(diff, freqMap.getOrDefault(diff, 0L) + 1);
        }
        
        // Total pairs - good pairs = bad pairs
        long totalPairs = (long) n * (n - 1) / 2;
        return totalPairs - goodPairs;
    }
}
