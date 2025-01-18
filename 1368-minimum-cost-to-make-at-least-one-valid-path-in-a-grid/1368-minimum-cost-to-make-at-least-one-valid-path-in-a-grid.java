class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;       // Rows in the grid
        int n = grid[0].length;    // Columns in the grid
        
        // Directions for the grid: Right, Left, Down, Up
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // Priority Queue for BFS (min-cost exploration)
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        
        // Start BFS from (0, 0) with initial cost 0
        deque.offerFirst(new int[]{0, 0, 0}); // [row, col, cost]
        
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int row = current[0];
            int col = current[1];
            int cost = current[2];
            
            // If the bottom-right cell is reached, return the cost
            if (row == m - 1 && col == n - 1)
                return cost;
            
            // Skip processing if already visited
            if (visited[row][col])
                continue;
            
            visited[row][col] = true; // Mark as visited
            
            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];
                int newCost = cost + (grid[row][col] == i + 1 ? 0 : 1); // Add cost if direction changes
                
                // Check bounds and visit unvisited cells
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    // Use deque to prioritize minimum cost
                    if (grid[row][col] == i + 1) {
                        deque.offerFirst(new int[]{newRow, newCol, newCost}); // Add to front for same direction
                    } else {
                        deque.offerLast(new int[]{newRow, newCol, newCost}); // Add to back for direction change
                    }
                }
            }
        }
        
        return -1; // Return -1 if no valid path exists (shouldn't happen with valid input)
    }
}
