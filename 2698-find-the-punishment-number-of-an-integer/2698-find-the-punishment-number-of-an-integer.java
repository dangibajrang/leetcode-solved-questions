class Solution {
    // Function to calculate the punishment number of a given integer n
    public int punishmentNumber(int n) {
        int sum = 0; // Initialize the sum variable to store the total punishment number
        
        // Iterate over all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            int square = i * i; // Compute the square of the current number
            
            // Check if the square can be partitioned into parts summing to the original number
            if (canPartition(String.valueOf(square), i, 0, 0)) {
                sum += square; // If true, add the square to the total sum
            }
        }
        
        return sum; // Return the final punishment number sum
    }
    
    // Helper function to check if the square of a number can be partitioned to sum up to the original number
    private boolean canPartition(String s, int target, int index, int currentSum) {
        // If we have reached the end of the string, check if the sum matches the target
        if (index == s.length()) {
            return currentSum == target;
        }
        
        int num = 0; // Variable to form partitioned numbers
        
        // Iterate over possible partitions
        for (int i = index; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0'); // Extract digit and form number
            
            // Recursively check the next partitions
            if (canPartition(s, target, i + 1, currentSum + num)) {
                return true; // If a valid partition is found, return true
            }
        }
        
        return false; // Return false if no valid partition is found
    }
}
