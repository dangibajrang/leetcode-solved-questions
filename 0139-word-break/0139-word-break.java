
// class Solution {
//   // Method to determine if the string `s` can be segmented into words from `wordDict`.
//   public boolean wordBreak(String s, List<String> wordDict) {
//     // Convert the wordDict into a HashSet for faster lookups.
//     Set<String> wordSet = new HashSet<>(wordDict);
    
//     // dp[i] indicates if the substring `s[0..i)` can be segmented into dictionary words.
//     boolean[] dp = new boolean[s.length() + 1];
    
//     // Base case: The empty string can always be segmented (i.e., zero-length string can be segmented).
//     dp[0] = true;

//     // Loop through each character in the string `s` (from 1 to the length of the string).
//     for (int i = 1; i <= s.length(); i++) {
//       // Check each possible starting position `j` (from 0 to `i`).
//       for (int j = 0; j < i; j++) {
//         // If the substring `s[0..j)` can be segmented and `s[j..i)` is in the dictionary,
//         // then `s[0..i)` can be segmented.
//         if (dp[j] && wordSet.contains(s.substring(j, i))) {
//           dp[i] = true;
//           break;  // No need to check further; move to the next `i`.
//         }
//       }
//     }

//     // Return whether the entire string `s` can be segmented.
//     return dp[s.length()];
//   }

// }




class Solution {
    Set<String> dict;  // Set to store the dictionary words for quick lookup.
    HashMap<String, Boolean> cache = new HashMap<>();  // Cache (memoization) to store results of subproblems.

    // Main method that initiates the word break check.
    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);  // Convert the word dictionary into a HashSet for faster lookup.
        return helper(s);  // Call the helper method to solve the problem recursively.
    }

    // Recursive helper function to check if the string can be segmented.
    private boolean helper(String s) {
        if (s == null || s.length() == 0) return true;  // Base case: If the string is empty, return true.
        
        // Check if the result for the current string 's' is already cached.
        if (cache.containsKey(s)) {
            return cache.get(s);  // If found in the cache, return the cached result.
        }

        int n = s.length();  // Get the length of the current string.

        // Iterate over all possible splits of the string.
        for (int i = 1; i <= n; i++) {
            String Left = s.substring(0, i);  // Left substring from the start to 'i'.
            String Right = s.substring(i, n);  // Right substring from 'i' to the end.

            // If the left part is in the dictionary and the right part can also be segmented (recursive call).
            if (dict.contains(Left) && helper(Right)) {
                cache.put(s, true);  // Cache the result as true for this string 's'.
                return true;  // Return true as the string can be segmented.
            }
        }

        // If no valid segmentation is found, cache the result as false for this string 's'.
        cache.put(s, false);
        return false;  // Return false as the string cannot be segmented.
    }
}
