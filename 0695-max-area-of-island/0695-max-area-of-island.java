class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length, cols = grid[0].length;
        int maxArea = 0;

        // Traverse the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) { // Found land
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        // Base case: If out of bounds or at water (0), return 0
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0; // Mark cell as visited
        int area = 1; // Count this cell

        // Explore all four possible directions and accumulate the area
        area += dfs(grid, r - 1, c); // Up
        area += dfs(grid, r + 1, c); // Down
        area += dfs(grid, r, c - 1); // Left
        area += dfs(grid, r, c + 1); // Right

        return area;
    }
}
