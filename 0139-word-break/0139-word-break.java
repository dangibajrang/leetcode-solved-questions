
class Solution {
  // Method to determine if the string `s` can be segmented into words from `wordDict`.
  public boolean wordBreak(String s, List<String> wordDict) {
    // Convert the wordDict into a HashSet for faster lookups.
    Set<String> wordSet = new HashSet<>(wordDict);
    
    // dp[i] indicates if the substring `s[0..i)` can be segmented into dictionary words.
    boolean[] dp = new boolean[s.length() + 1];
    
    // Base case: The empty string can always be segmented (i.e., zero-length string can be segmented).
    dp[0] = true;

    // Loop through each character in the string `s` (from 1 to the length of the string).
    for (int i = 1; i <= s.length(); i++) {
      // Check each possible starting position `j` (from 0 to `i`).
      for (int j = 0; j < i; j++) {
        // If the substring `s[0..j)` can be segmented and `s[j..i)` is in the dictionary,
        // then `s[0..i)` can be segmented.
        if (dp[j] && wordSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;  // No need to check further; move to the next `i`.
        }
      }
    }

    // Return whether the entire string `s` can be segmented.
    return dp[s.length()];
  }

}
