class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;  // Start from the first lexicographical number '1'
        k = k - 1;     // We start counting from 0, so decrement k by 1

        // While k > 0, we need to find the k-th number
        while (k > 0) {
            // Get the count of numbers starting with 'curr'
            long step = countSteps(n, curr, curr + 1);

            // If k is greater than or equal to the step count, skip this subtree
            if (step <= k) {
                curr += 1;    // Move to the next sibling
                k -= step;    // Reduce k by the step count
            } else {
                curr *= 10;   // Move to the next child in the tree (deeper in the current branch)
                k -= 1;       // We've found the current number, reduce k by 1
            }
        }
        return curr;  // Return the k-th lexicographical number
    }

    // Function to count the number of steps between two numbers in lexicographical order
    private long countSteps(int n, long curr, long next) {
        long steps = 0;  // Initialize step count
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;  // Count the valid numbers in the current range
            curr *= 10;  // Move to the next level (deeper in the tree)
            next *= 10;  // Corresponding range at the next level
        }
        return steps;  // Return the total number of steps
    }
}
