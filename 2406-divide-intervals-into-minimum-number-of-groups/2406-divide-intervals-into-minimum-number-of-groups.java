class Solution {
    public int minGroups(int[][] intervals) {
        // Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // Min-heap to track the end times of groups
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int[] interval : intervals) {
            // If the current interval's start time is greater than or equal to the earliest ending interval
            if (!minHeap.isEmpty() && minHeap.peek() < interval[0]) {
                minHeap.poll(); // Remove the group that can be merged
            }
            // Add the current interval's end time to the heap
            minHeap.add(interval[1]);
        }
        
        // The number of groups is the size of the heap
        return minHeap.size();
        
    }
}