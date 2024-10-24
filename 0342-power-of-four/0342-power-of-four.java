class Solution {
    public boolean isPowerOfFour(int n) {
          // Base case: n must be greater than 0
        if (n <= 0) return false;
        // Base case: 1 is a power of four (4^0)
        if (n == 1) return true;
        // Recursive case: check if n is divisible by 4
        if (n % 4 == 0) {
            return isPowerOfFour(n / 4);
        }
        // If n is not divisible by 4, it's not a power of four
        return false;
        
    }
}