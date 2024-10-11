class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        // PriorityQueue to store available chairs in ascending order
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        // Fill all chairs initially
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        // PriorityQueue to store people leaving by their leaving times
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Add index to the times array to track person index
        int[][] timesWithIndex = new int[n][3];
        for (int i = 0; i < n; i++) {
            timesWithIndex[i][0] = times[i][0];  // arrival time
            timesWithIndex[i][1] = times[i][1];  // leaving time
            timesWithIndex[i][2] = i;            // person index
        }

        // Sort the times by arrival times
        Arrays.sort(timesWithIndex, (a, b) -> a[0] - b[0]);

        // Process each person in the sorted arrival order
        for (int[] person : timesWithIndex) {
            int arrival = person[0];
            int leaving = person[1];
            int personIndex = person[2];

            // Free up chairs of people who have left before current person arrives
            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrival) {
                availableChairs.add(leavingQueue.poll()[1]);  // Add chair back to available
            }

            // Assign the smallest available chair to the current person
            int chair = availableChairs.poll();

            // If this is the target person, return the chair number
            if (personIndex == targetFriend) {
                return chair;
            }

            // Add this person's leaving time and their chair to the leavingQueue
            leavingQueue.add(new int[]{leaving, chair});
        }

        return -1; // This should never be reached if input is valid
    }

}
