class Solution {
  // Method to count the number of digit 1 occurrences in the range from 1 to n
  public int countDigitOne(int n) {
    // Initialize the answer variable
    int ans = 0;

    // Loop through powers of 10, from 1 to n
    for (long pow10 = 1; pow10 <= n; pow10 *= 10) {
      // Calculate the divisor for the current power of 10
      final long divisor = pow10 * 10;
      
      // Calculate the quotient and remainder when dividing n by the divisor
      final int quotient = (int) (n / divisor);
      final int remainder = (int) (n % divisor);

      // If the quotient is greater than 0, add the contribution of 1s to the answer
      if (quotient > 0)
        ans += quotient * pow10;
      
      // If the remainder is greater than or equal to the current power of 10
      if (remainder >= pow10)
        // Add the contribution of 1s to the answer using Math.min to handle edge cases
        ans += Math.min(remainder - pow10 + 1, pow10);
    }

    // Return the final answer
    return ans;
  }
}
