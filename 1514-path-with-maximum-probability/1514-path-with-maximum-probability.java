class Solution {
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    List<List<Pair<Integer, Double>>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      double prob = succProb[i];
      graph.get(u).add(new Pair<>(v, prob));
      graph.get(v).add(new Pair<>(u, prob));
    }

    PriorityQueue<Pair<Double, Integer>> maxHeap = 
        new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
    maxHeap.offer(new Pair<>(1.0, start));

    boolean[] visited = new boolean[n];

    while (!maxHeap.isEmpty()) {
      Pair<Double, Integer> current = maxHeap.poll();
      double prob = current.getKey();
      int node = current.getValue();

      if (node == end) {
        return prob;
      }
      if (visited[node]) {
        continue;
      }

      visited[node] = true;

      for (Pair<Integer, Double> neighbor : graph.get(node)) {
        if (!visited[neighbor.getKey()]) {
          maxHeap.offer(new Pair<>(prob * neighbor.getValue(), neighbor.getKey()));
        }
      }
    }

    return 0.0;
  }
}
