
public class Solution {
    public List<List<String>> partition(String s) {
        // Result list to store all the palindrome partitions
        List<List<String>> result = new ArrayList<>();
        
        // Start the recursive backtracking process
        backtrack(s, 0, new ArrayList<>(), result);
        
        // Return the final list of palindrome partitions
        return result;
    }

    // Helper method to perform backtracking
    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        // If start index reaches the end of the string, add the current partition to the result
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // Explore all possible partitions starting from 'start' index
        for (int end = start; end < s.length(); end++) {
            // Check if the substring s[start:end+1] is a palindrome
            if (isPalindrome(s, start, end)) {
                // If it is, add it to the current partition
                currentPartition.add(s.substring(start, end + 1));
                
                // Recurse to explore further partitions from end+1
                backtrack(s, end + 1, currentPartition, result);
                
                // Backtrack: Remove the last added substring to explore other possibilities
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    // Utility method to check if a substring s[start:end+1] is a palindrome
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        List<List<String>> result = solution.partition(s);
        System.out.println(result);
    }
}
