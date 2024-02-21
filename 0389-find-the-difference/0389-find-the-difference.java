class Solution {
  public char findTheDifference(String s, String t) {
    // Create an array to store the count of each character in 's'
    int[] count = new int[26];

    // Iterate through each character in string 's'
    for (final char c : s.toCharArray())
      // Increment the count for the corresponding character in the array
      ++count[c - 'a'];

    // Iterate through each character in string 't'
    for (final char c : t.toCharArray()) {
      // If the count for this character in 's' is already 0, return this character
      if (count[c - 'a'] == 0)
        return c;
      // Otherwise, decrement the count for this character in the array
      --count[c - 'a'];
    }

    // If the loops complete without finding the differing character, throw an exception
    throw new IllegalArgumentException();
  }
}
