// class Solution {
//     public int[][] highestPeak(int[][] isWater) {
//         int m = isWater.length;                       // Number of rows
//         int n = isWater[0].length;                    // Number of columns
//         int[][] heights = new int[m][n];              // Resultant heights matrix
//         for (int[] row : heights)                     // Initialize heights to -1
//             Arrays.fill(row, -1);

//         Queue<int[]> queue = new LinkedList<>();      // BFS queue to process cells
//         int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Possible directions (right, down, left, up)

//         // Add all water cells to the queue with height 0
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (isWater[i][j] == 1) {             // If the cell is water
//                     queue.add(new int[]{i, j});       // Add to queue
//                     heights[i][j] = 0;                // Set height to 0
//                 }
//             }
//         }

//         // Perform BFS
//         while (!queue.isEmpty()) {
//             int[] cell = queue.poll();                // Process the next cell in the queue
//             int x = cell[0], y = cell[1];             // Get cell coordinates

//             for (int[] dir : directions) {            // Check all 4 neighbors
//                 int newX = x + dir[0];                // Calculate new row
//                 int newY = y + dir[1];                // Calculate new column

//                 // If the new cell is valid and unvisited
//                 if (newX >= 0 && newX < m && newY >= 0 && newY < n && heights[newX][newY] == -1) {
//                     heights[newX][newY] = heights[x][y] + 1; // Assign height (parent height + 1)
//                     queue.add(new int[]{newX, newY});  // Add the cell to the queue for further processing
//                 }
//             }
//         }

//         return heights;                               // Return the resultant height matrix
//     }
// }



class Solution {
    public int[][] highestPeak(int[][] isWater) {
        // Define directions for up, right, down, and left
        int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        // Get the dimensions of the input grid
        int n = isWater.length;
        int m = isWater[0].length;

        // Initialize the result grid with the same dimensions
        int res[][] = new int[n][m];

        // Create a queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();

        // Fill the queue with water cells and mark other cells as unvisited (-1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) { // If the cell is water
                    res[i][j] = 0; // Water cells have height 0
                    queue.offer(new int[]{i, j}); // Add the cell to the queue
                } else { 
                    res[i][j] = -1; // Mark land cells as unvisited
                }
            }
        }

        // Perform BFS to calculate heights
        while (!queue.isEmpty()) {
            // Poll the front cell from the queue
            int cell[] = queue.poll();
            int r = cell[0]; // Current row
            int c = cell[1]; // Current column
            int h = res[r][c]; // Current height

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0]; // New row
                int nc = c + dir[i][1]; // New column

                // Check if the new cell is within bounds and unvisited
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && res[nr][nc] == -1) {
                    res[nr][nc] = h + 1; // Set the height of the new cell
                    queue.offer(new int[]{nr, nc}); // Add the new cell to the queue
                }
            }
        }

        // Return the result grid with calculated heights
        return res;
    }
}
