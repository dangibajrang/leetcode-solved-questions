class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length, n = grid2[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        // Boundary conditions
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length) return true;
        
        // If it's water or already visited
        if (grid2[i][j] == 0) return true;

        // Mark this cell as visited in grid2
        grid2[i][j] = 0;

        // Check if this cell is not a sub-island part
        boolean isSubIsland = grid1[i][j] == 1;

        // Perform DFS in all 4 directions
        isSubIsland &= dfs(grid1, grid2, i + 1, j);
        isSubIsland &= dfs(grid1, grid2, i - 1, j);
        isSubIsland &= dfs(grid1, grid2, i, j + 1);
        isSubIsland &= dfs(grid1, grid2, i, j - 1);

        return isSubIsland;
    }
}
