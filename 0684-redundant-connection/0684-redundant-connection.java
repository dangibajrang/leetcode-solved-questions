class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        // Iterate through each edge in the given list
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // If adding this edge forms a cycle, return it as the answer
            if (!uf.union(u, v)) {
                return edge;
            }
        }
        return new int[0]; // This case should never occur in valid inputs
    }
}

// Union-Find (Disjoint Set) Helper Class
class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size + 1]; // Parent array (1-based index)
        rank = new int[size + 1];   // Rank array for optimization

        // Initialize each node as its own parent (self-loop)
        for (int i = 1; i <= size; i++) {
            parent[i] = i;
        }
    }

    // Find the root parent of a node with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // Union operation: Merge two sets, return false if they are already connected (cycle detected)
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false; // Cycle detected

        // Union by rank optimization
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}
