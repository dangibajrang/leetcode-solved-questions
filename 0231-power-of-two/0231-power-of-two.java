class Solution {
  public boolean isPowerOfTwo(int n) {
    // if (n <= 0) {
    //   return false;
    // }
    // while (n % 2 == 0) {
    //   n /= 2;
    // }
    // return n == 1;

        // Base case: n must be greater than 0
        if (n <= 0) return false;
        // Base case: 1 is a power of two (2^0)
        if (n == 1) return true;
        // Recursive case: check if n is even and call the function with n / 2
        if (n % 2 == 0) {
            return isPowerOfTwo(n / 2);
        }
        // If n is odd and not 1, it's not a power of two
        return false;
  }
}
