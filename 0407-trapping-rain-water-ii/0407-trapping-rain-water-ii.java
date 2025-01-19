
class Solution {
  private static final int[] dirs = {0, 1, 0, -1, 0};

  public int trapRainWater(int[][] heightMap) {
    if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
      return 0;

    int m = heightMap.length;
    int n = heightMap[0].length;
    int ans = 0;

    // Min-Heap to always process the cell with the smallest height
    Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
    boolean[][] visited = new boolean[m][n];

    // Add all boundary cells to the priority queue
    for (int i = 0; i < m; ++i) {
      pq.offer(new int[] {i, 0, heightMap[i][0]});
      pq.offer(new int[] {i, n - 1, heightMap[i][n - 1]});
      visited[i][0] = true;
      visited[i][n - 1] = true;
    }

    for (int j = 0; j < n; ++j) {
      pq.offer(new int[] {0, j, heightMap[0][j]});
      pq.offer(new int[] {m - 1, j, heightMap[m - 1][j]});
      visited[0][j] = true;
      visited[m - 1][j] = true;
    }

    // Process the cells in the priority queue
    while (!pq.isEmpty()) {
      int[] cell = pq.poll();
      int x = cell[0];
      int y = cell[1];
      int h = cell[2];

      // Check all four directions
      for (int i = 0; i < 4; ++i) {
        int nx = x + dirs[i];
        int ny = y + dirs[i + 1];

        if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
          visited[nx][ny] = true;

          // Calculate the trapped water at the neighbor
          ans += Math.max(0, h - heightMap[nx][ny]);

          // Update the boundary with the maximum height of the current boundary or the neighbor's height
          pq.offer(new int[] {nx, ny, Math.max(h, heightMap[nx][ny])});
        }
      }
    }

    return ans;
  }
}
