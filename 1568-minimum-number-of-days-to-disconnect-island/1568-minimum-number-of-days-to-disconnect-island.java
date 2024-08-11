class Solution {
    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Check if the grid is already disconnected
        if (isDisconnected(grid)) return 0;

        // Try removing each land cell and check if it disconnects the island
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isDisconnected(grid)) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        
        // If no single land removal works, return 2 (by default since 30x30 grid is small enough)
        return 2;
    }
    
    private boolean isDisconnected(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;

        // Use DFS to count the number of islands
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (islands > 0) return true; // More than one island found
                    dfs(grid, visited, i, j);
                    islands++;
                }
            }
        }

        return islands != 1; // If exactly one island, return false; otherwise true
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int row, int col) {
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }
}
