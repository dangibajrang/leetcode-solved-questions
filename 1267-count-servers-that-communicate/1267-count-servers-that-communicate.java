class Solution {
    public int countServers(int[][] grid) {
        // Get the number of rows and columns in the grid
        int n = grid.length;
        int m = grid[0].length;
        
        // Arrays to store the count of servers in each row and column
        int[] rowCount = new int[n];
        int[] colCount = new int[m];
        
        // Variable to store the total number of servers
        int count = 0;

        // Traverse the grid and count the servers in each row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;  // Increment server count for row i
                    colCount[j]++;  // Increment server count for column j
                    count++;         // Increment total server count
                }
            }
        }

        // Traverse the grid again to check for unreachable servers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // Remove servers that are not connected to any other server
                    // If the row and column both have only 1 server, it's unreachable
                    if (rowCount[i] == 1 && colCount[j] == 1) {
                        count--;  // Decrease the count for unreachable server
                    }
                }
            }
        }

        // Return the total number of servers that can communicate with other servers
        return count;
    }
}
