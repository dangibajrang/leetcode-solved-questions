
class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals by their start time.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Create a linked list to store the merged intervals.
        LinkedList<int[]> merged = new LinkedList<>();
        
        // Iterate over the intervals.
        for (int[] interval : intervals) {
            // If the list is empty or the current interval does not overlap with the last one, append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Otherwise, merge the current interval with the last one.
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        // Return the merged intervals as a 2D array.
        return merged.toArray(new int[merged.size()][]);
    }
}
