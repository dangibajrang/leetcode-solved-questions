class Solution {
  public int findTheLongestSubstring(String s) {
    // Define a string containing all the vowels
    final String kVowels = "aeiou";
    
    // Initialize the variable to store the maximum length of the substring
    int ans = 0;
    
    // Initialize the prefix to 0, representing the binary mask for vowel occurrences
    int prefix = 0;
    
    // Map to store the first occurrence of each binary prefix value
    // Key: binary prefix, Value: first index where this prefix occurs
    Map<Integer, Integer> prefixToIndex = new HashMap<>();
    
    // The prefix 0 (all vowels even) is initially mapped to index -1
    prefixToIndex.put(0, -1);

    // Iterate over the string characters
    for (int i = 0; i < s.length(); ++i) {
      // Get the index of the current character in the vowel string (if it is a vowel)
      final int index = kVowels.indexOf(s.charAt(i));
      
      // If the character is a vowel, update the prefix by flipping the bit at its position
      if (index != -1)
        prefix ^= 1 << index;
      
      // If the prefix is encountered for the first time, store its index
      prefixToIndex.putIfAbsent(prefix, i);
      
      // Calculate the current longest substring length by comparing with the previous result
      ans = Math.max(ans, i - prefixToIndex.get(prefix));
    }

    // Return the length of the longest substring with even occurrences of vowels
    return ans;
  }
}
