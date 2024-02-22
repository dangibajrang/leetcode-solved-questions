class Solution {
  // Method to calculate the minimum number of squares needed to tile an n x m rectangle
  public int tilingRectangle(int n, int m) {
    return tilingRectangle(n, m, 0, new int[m]);
  }

  // Constants
  private static final int kBase = 13;
  private Map<Long, Integer> dp = new HashMap<>();

  // Recursive method to calculate the minimum number of squares
  private int tilingRectangle(int n, int m, long hashedHeights, int[] heights) {
    // Check if the solution for the current state is already calculated
    if (dp.containsKey(hashedHeights))
      return dp.get(hashedHeights);

    // Calculate the minimum height among all columns
    final int minHeight = Arrays.stream(heights).min().getAsInt();
    
    // If all columns are filled, return 0 (base case)
    if (minHeight == n)
      return 0;

    // Initialize ans with the maximum possible value
    int ans = m * n;
    int start = -1;

    // Find the index of the first column with the minimum height
    for (int i = 0; i < m; ++i)
      if (heights[i] == minHeight) {
        start = i;
        break;
      }

    // Try to put squares of different sizes that don't exceed the width/height
    for (int sz = 1; sz <= Math.min(m - start, n - minHeight); ++sz) {
      // Check if heights[start..start + sz) have the same height
      if (heights[start + sz - 1] != minHeight)
        break;

      // Put a square of size `sz` to cover heights[start..start + sz)
      for (int i = start; i < start + sz; ++i)
        heights[i] += sz;

      // Recursively call tilingRectangle for the updated state
      ans = Math.min(ans, tilingRectangle(n, m, hash(heights), heights));

      // Backtrack by subtracting the square's size from the heights
      for (int i = start; i < start + sz; ++i)
        heights[i] -= sz;
    }

    // Memoize the result and return the calculated answer
    dp.put(hashedHeights, 1 + ans);
    return 1 + ans;
  }

  // Method to hash an array of heights
  private long hash(int[] heights) {
    long hashed = 0;
    for (int i = heights.length - 1; i >= 0; --i)
      hashed = hashed * kBase + heights[i];
    return hashed;
  }
}
