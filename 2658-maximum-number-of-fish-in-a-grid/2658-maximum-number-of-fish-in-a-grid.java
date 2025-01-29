class Solution {
    int rows, cols;

    public int findMaxFish(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int maxFishes = 0;

        // Iterate over the entire grid to find connected components of fish
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the current cell contains fish, perform DFS
                if (grid[i][j] > 0) {
                    maxFishes = Math.max(maxFishes, dfs(grid, i, j));
                }
            }
        }
        return maxFishes;
    }

    private int dfs(int[][] grid, int r, int c) {
        // Base case: Check if out of bounds or water (0) cell
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return 0;
        }

        int fishCount = grid[r][c]; // Collect fish from the current cell
        grid[r][c] = 0; // Mark as visited by setting it to 0

        // Explore all four possible directions (up, right, down, left)
        fishCount += dfs(grid, r - 1, c); // Up
        fishCount += dfs(grid, r, c + 1); // Right
        fishCount += dfs(grid, r + 1, c); // Down
        fishCount += dfs(grid, r, c - 1); // Left

        return fishCount;
    }
}
