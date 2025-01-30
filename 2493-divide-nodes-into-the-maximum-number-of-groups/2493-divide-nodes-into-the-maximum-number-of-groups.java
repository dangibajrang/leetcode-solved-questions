import java.util.*;

class UnionFind {
    private int[] parent;
    private int[] rank;

    // Constructor to initialize Union-Find structure
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each node is initially its own parent
            rank[i] = 0; // Initial rank is 0
        }
    }

    // Find operation with path compression
    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]); // Path compression
        }
        return parent[u];
    }

    // Union operation by rank
    public void unionByRank(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) {
            return; // They are already in the same set
        }
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV; // Attach smaller tree under larger tree
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootU] = rootV;
            rank[rootV]++; // Increase rank when merging trees of the same rank
        }
    }
}

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> rootToGroupSize = new HashMap<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and perform union operation
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
            uf.unionByRank(u, v);
        }

        // Process each node to determine the maximum group size
        for (int i = 0; i < n; i++) {
            int newGroupSize = bfs(graph, i);
            if (newGroupSize == -1) {
                return -1; // Odd cycle detected, return -1
            }
            int root = uf.find(i);
            rootToGroupSize.put(root, Math.max(rootToGroupSize.getOrDefault(root, 0), newGroupSize));
        }

        int ans = 0;
        // Sum up the largest group sizes from each connected component
        for (int groupSize : rootToGroupSize.values()) {
            ans += groupSize;
        }

        return ans;
    }

    // Perform BFS to check bipartiteness and find the max depth
    private int bfs(List<List<Integer>> graph, int start) {
        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Map<Integer, Integer> nodeToStep = new HashMap<>();
        nodeToStep.put(start, 1);

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                for (int v : graph.get(u)) {
                    if (!nodeToStep.containsKey(v)) {
                        queue.offer(v);
                        nodeToStep.put(v, step + 1);
                    } else if (nodeToStep.get(v) == step) {
                        return -1; // Odd-length cycle detected
                    }
                }
            }
        }

        return step;
    }
}
