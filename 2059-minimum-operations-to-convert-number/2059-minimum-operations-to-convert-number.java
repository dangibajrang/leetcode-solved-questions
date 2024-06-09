import java.util.*;

class Solution {
  public int minimumOperations(int[] nums, int start, int goal) {
    // Initialize the number of operations to 0
    int operations = 0;
    // Queue to perform BFS, starting with the initial value 'start'
    Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(start));
    // Array to track visited values, to avoid processing the same value multiple times
    boolean[] visited = new boolean[1001];
    visited[start] = true;

    // Perform BFS
    while (!queue.isEmpty()) {
      operations++; // Increment the operation count at the start of each level

      // Process all nodes at the current level
      for (int size = queue.size(); size > 0; size--) {
        int current = queue.poll(); // Get the next value from the queue

        // Apply each operation (+, -, ^) using each number in 'nums'
        for (int num : nums) {
          int[] results = {current + num, current - num, current ^ num};

          // Check each result of the operations
          for (int result : results) {
            // If the result matches the goal, return the number of operations
            if (result == goal) {
              return operations;
            }
            // Skip invalid results or results that have been seen already
            if (result < 0 || result > 1000 || visited[result]) {
              continue;
            }

            // Mark the result as visited and add it to the queue for further processing
            visited[result] = true;
            queue.offer(result);
          }
        }
      }
    }

    // If the goal is not reachable, return -1
    return -1;
  }
}
