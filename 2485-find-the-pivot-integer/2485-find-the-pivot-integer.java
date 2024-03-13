class Solution {
  public int pivotInteger(int n) {
    // Calculate the sum of the series 1 + 2 + ... + x, where x is the pivot integer
    // and the sum of the series x + ... + n
    // (1 + x) * x / 2 = (x + n) * (n - x + 1) / 2
    // (sum of series 1 to x) = (sum of series x to n)

    // Calculate the sum of the series 1 + 2 + ... + x
    final int y = (n * n + n) / 2;
    
    // Find the value of x using the formula x = sqrt((n^2 + n) / 2)
    final int x = (int) Math.sqrt(y);
    
    // Check if x is a valid pivot integer by verifying if the sum of series
    // 1 + 2 + ... + x is equal to the sum of series x + ... + n
    return x * x == y ? x : -1;
    // Return x if it satisfies the condition, otherwise return -1
  }
}
