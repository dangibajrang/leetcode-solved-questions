class Solution {
  public int removeStones(int[][] stones) {
    int numOfIslands = 0;  // To count the number of connected components (islands)
    List<Integer>[] graph = new List[stones.length];  // Adjacency list representation of the graph
    Set<Integer> seen = new HashSet<>();  // To keep track of visited nodes (stones)

    // Initialize the adjacency list for each stone
    for (int i = 0; i < stones.length; ++i)
      graph[i] = new ArrayList<>();

    // Build the graph by adding edges between stones in the same row or column
    for (int i = 0; i < stones.length; ++i)
      for (int j = i + 1; j < stones.length; ++j)
        if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
          graph[i].add(j);  // Connect stone i with stone j
          graph[j].add(i);  // Connect stone j with stone i
        }

    // Perform DFS to count the number of connected components
    for (int i = 0; i < stones.length; ++i)
      if (seen.add(i)) {  // If the stone is not visited, it's a new connected component
        dfs(graph, i, seen);  // Explore all stones connected to this one
        ++numOfIslands;  // Increment the number of islands
      }

    // The result is the total number of stones minus the number of islands
    return stones.length - numOfIslands;
  }

  // Depth-First Search to explore all connected stones
  private void dfs(List<Integer>[] graph, int u, Set<Integer> seen) {
    for (int v : graph[u])  // Iterate through all stones connected to stone u
      if (seen.add(v))  // If the stone is not visited, visit it
        dfs(graph, v, seen);  // Recursively visit all connected stones
  }
}
