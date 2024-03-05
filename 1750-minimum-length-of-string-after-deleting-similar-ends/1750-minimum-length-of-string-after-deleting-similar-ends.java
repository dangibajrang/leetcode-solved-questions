class Solution {
  public int minimumLength(String s) {
    int i = 0; // Initialize a pointer 'i' at the beginning of the string.
    int j = s.length() - 1; // Initialize a pointer 'j' at the end of the string.

    // While 'i' is less than 'j' and characters at positions 'i' and 'j' are equal,
    while (i < j && s.charAt(i) == s.charAt(j)) {
      final char c = s.charAt(i); // Store the common character in a variable 'c'.

      // Increment 'i' until a different character is encountered.
      while (i <= j && s.charAt(i) == c)
        ++i;

      // Decrement 'j' until a different character is encountered.
      while (i <= j && s.charAt(j) == c)
        --j;
    }

    // Calculate and return the length of the remaining substring.
    return j - i + 1;
  }
}
