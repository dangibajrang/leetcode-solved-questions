class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] expandedGrid = new int[3 * n][3 * n];
        
        // Expand the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    expandedGrid[3 * i][3 * j + 2] = 1;
                    expandedGrid[3 * i + 1][3 * j + 1] = 1;
                    expandedGrid[3 * i + 2][3 * j] = 1;
                } else if (c == '\\') {
                    expandedGrid[3 * i][3 * j] = 1;
                    expandedGrid[3 * i + 1][3 * j + 1] = 1;
                    expandedGrid[3 * i + 2][3 * j + 2] = 1;
                }
            }
        }
        
        // Count the number of regions using DFS
        int regions = 0;
        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                if (expandedGrid[i][j] == 0) {
                    dfs(expandedGrid, i, j);
                    regions++;
                }
            }
        }
        
        return regions;
    }
    
    // DFS to mark all connected parts of a region
    private void dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 0) {
            return;
        }
        grid[i][j] = 1;  // Mark the cell as visited
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

