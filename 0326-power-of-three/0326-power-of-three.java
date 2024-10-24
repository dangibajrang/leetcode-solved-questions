class Solution {
    public boolean isPowerOfThree(int n) {
            // Base case: n must be greater than 0
        if (n <= 0) return false;
        // Base case: 1 is a power of three (3^0)
        if (n == 1) return true;
        // Recursive case: check if n is divisible by 3
        if (n % 3 == 0) {
            return isPowerOfThree(n / 3);
        }
        // If n is not divisible by 3, it's not a power of three
        return false;
        
    }
}