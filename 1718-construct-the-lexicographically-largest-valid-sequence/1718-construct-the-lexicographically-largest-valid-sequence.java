class Solution {
    // Function to construct the lexicographically largest valid sequence
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1]; // Array to store the final sequence
        boolean[] used = new boolean[n + 1]; // Track used numbers
        
        // Start backtracking from index 0
        backtrack(result, used, 0, n);
        return result; // Return the constructed sequence
    }
    
    // Helper function to fill the sequence using backtracking
    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        // If we have filled the entire array, return true
        if (index == result.length) {
            return true;
        }
        
        // If the current position is already filled, move to the next index
        if (result[index] != 0) {
            return backtrack(result, used, index + 1, n);
        }
        
        // Try placing numbers from n to 1 (lexicographically largest first)
        for (int num = n; num > 0; num--) {
            if (used[num]) continue; // Skip if number is already used
            
            int secondIndex = (num == 1) ? index : index + num; // Compute second occurrence position
            
            // Check if the number can be placed
            if (secondIndex < result.length && result[secondIndex] == 0) {
                result[index] = num; // Place first occurrence
                result[secondIndex] = num; // Place second occurrence
                used[num] = true; // Mark number as used
                
                // Recursively try the next placement
                if (backtrack(result, used, index + 1, n)) {
                    return true;
                }
                
                // Backtrack if the placement didn't work
                result[index] = 0;
                result[secondIndex] = 0;
                used[num] = false;
            }
        }
        
        return false; // Return false if no valid placement is found
    }
}