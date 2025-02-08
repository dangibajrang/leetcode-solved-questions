// class Solution {
//     public int numIslands(char[][] grid) {
//         if (grid == null || grid.length == 0) return 0;

//         int rows = grid.length, cols = grid[0].length;
//         int islandCount = 0;

//         // Traverse the grid
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 if (grid[i][j] == '1') { // Found an unvisited land cell
//                     islandCount++; // Count this island
//                     dfs(grid, i, j); // Mark the whole island as visited
//                 }
//             }
//         }
//         return islandCount;
//     }

//     private void dfs(char[][] grid, int r, int c) {
//         // Base case: If out of bounds or at water ('0'), return
//         if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
//             return;
//         }

//         grid[r][c] = '0'; // Mark cell as visited (sink the island)

//         // Explore all four possible directions
//         dfs(grid, r - 1, c); // Up
//         dfs(grid, r + 1, c); // Down
//         dfs(grid, r, c - 1); // Left
//         dfs(grid, r, c + 1); // Right
//     }
// }


class UnionFind {
    private int[] parent;
    private int[] rank;
    private int count;  // Number of islands

    public UnionFind(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        parent = new int[rows * cols];
        rank = new int[rows * cols];
        count = 0;

        // Initialize sets
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    int index = r * cols + c;
                    parent[index] = index; // Initially, each land is its own set
                    count++; // Count initial islands
                }
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
            count--; // Merge islands → reduce island count
        }
    }

    public int getCount() {
        return count;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        // Directions for 4-neighbor connectivity (right, down, left, up)
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        // Traverse the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    // Convert (r, c) to 1D index
                    int index1 = r * cols + c;
                    
                    // Try to merge with its 4 neighbors
                    for (int[] dir : directions) {
                        int nr = r + dir[0], nc = c + dir[1];
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                            int index2 = nr * cols + nc;
                            uf.union(index1, index2);
                        }
                    }
                }
            }
        }

        return uf.getCount(); // Get total number of unique islands
    }


}

