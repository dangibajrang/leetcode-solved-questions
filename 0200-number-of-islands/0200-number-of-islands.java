class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length, cols = grid[0].length;
        int islandCount = 0;

        // Traverse the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') { // Found an unvisited land cell
                    islandCount++; // Count this island
                    dfs(grid, i, j); // Mark the whole island as visited
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c) {
        // Base case: If out of bounds or at water ('0'), return
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0'; // Mark cell as visited (sink the island)

        // Explore all four possible directions
        dfs(grid, r - 1, c); // Up
        dfs(grid, r + 1, c); // Down
        dfs(grid, r, c - 1); // Left
        dfs(grid, r, c + 1); // Right
    }
}
