import java.util.*;

class Solution {
  public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    List<int[]> projects = new ArrayList<>();
    for (int i = 0; i < Profits.length; ++i) {
      projects.add(new int[]{Capital[i], Profits[i]});
    }

    // Sort projects by their capital requirements in ascending order
    Collections.sort(projects, (a, b) -> a[0] - b[0]);

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    int i = 0;

    while (k-- > 0) {
      // Add all projects that can be started with current capital W to the maxHeap
      while (i < projects.size() && projects.get(i)[0] <= W) {
        maxHeap.add(projects.get(i)[1]);
        i++;
      }
      if (maxHeap.isEmpty()) {
        break;
      }
      // Select the project with the maximum profit
      W += maxHeap.poll();
    }

    return W;
  }
}
