public class Solution {
    // Method to check if a number is a happy number
    public boolean isHappy(int n) {
        // Initialize two pointers for cycle detection
        int tortoise = n;
        int hare = n;
        
        // Phase 1: Detect the cycle using the tortoise and hare approach
        do {
            tortoise = getNext(tortoise);       // Move tortoise one step
            hare = getNext(getNext(hare));      // Move hare two steps
        } while (tortoise != hare);              // Continue until they meet
        
        // If the tortoise pointer reaches 1, then it's a happy number
        return tortoise == 1;
    }
    
    // Helper method to compute the sum of squares of digits
    private int getNext(int number) {
        int totalSum = 0;
        while (number > 0) {
            int digit = number % 10;
            number /= 10;
            totalSum += digit * digit;
        }
        return totalSum;
    }
}
