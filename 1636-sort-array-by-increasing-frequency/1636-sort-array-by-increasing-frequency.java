class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a priority queue
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            // Sort by frequency in ascending order
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            // If frequencies are the same, sort by value in descending order
            return b[0] - a[0];
        });

        // Add elements to the priority queue
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            heap.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        // Step 3: Build the result array
        int[] result = new int[nums.length];
        int index = 0;

        while (!heap.isEmpty()) {
            int[] entry = heap.poll();
            int value = entry[0];
            int frequency = entry[1];
            for (int i = 0; i < frequency; i++) {
                result[index++] = value;
            }
        }

        return result;
    }
}
