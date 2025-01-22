class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;                       // Number of rows
        int n = isWater[0].length;                    // Number of columns
        int[][] heights = new int[m][n];              // Resultant heights matrix
        for (int[] row : heights)                     // Initialize heights to -1
            Arrays.fill(row, -1);

        Queue<int[]> queue = new LinkedList<>();      // BFS queue to process cells
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Possible directions (right, down, left, up)

        // Add all water cells to the queue with height 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {             // If the cell is water
                    queue.add(new int[]{i, j});       // Add to queue
                    heights[i][j] = 0;                // Set height to 0
                }
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();                // Process the next cell in the queue
            int x = cell[0], y = cell[1];             // Get cell coordinates

            for (int[] dir : directions) {            // Check all 4 neighbors
                int newX = x + dir[0];                // Calculate new row
                int newY = y + dir[1];                // Calculate new column

                // If the new cell is valid and unvisited
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && heights[newX][newY] == -1) {
                    heights[newX][newY] = heights[x][y] + 1; // Assign height (parent height + 1)
                    queue.add(new int[]{newX, newY});  // Add the cell to the queue for further processing
                }
            }
        }

        return heights;                               // Return the resultant height matrix
    }
}
