class Solution {
  // Method to count the total number of solutions for the N-Queens problem
  public int totalNQueens(int n) {
    // Initialize the answer variable
    dfs(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    return ans;
  }

  // Global variable to store the total number of solutions
  private int ans = 0;

  // Depth-first search (DFS) method to explore all possible configurations
  private void dfs(int n, int i, boolean[] cols, boolean[] diag1, boolean[] diag2) {
    // If all queens are placed (reached the end of the board), increment the answer and return
    if (i == n) {
      ++ans;
      return;
    }

    // Iterate through columns to try placing the queen in each column
    for (int j = 0; j < cols.length; ++j) {
      // Check if placing a queen at (i, j) is valid based on column and diagonal constraints
      if (cols[j] || diag1[i + j] || diag2[j - i + n - 1])
        continue;

      // Mark the column and diagonals as occupied
      cols[j] = diag1[i + j] = diag2[j - i + n - 1] = true;
      
      // Recursively call DFS for the next row
      dfs(n, i + 1, cols, diag1, diag2);
      
      // Backtrack by marking the column and diagonals as unoccupied
      cols[j] = diag1[i + j] = diag2[j - i + n - 1] = false;
    }
  }
}
