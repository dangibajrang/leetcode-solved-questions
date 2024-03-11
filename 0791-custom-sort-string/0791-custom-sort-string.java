class Solution {
  // Define a method named customSortString that takes two String parameters (order and s) and returns a String
  public String customSortString(final String order, final String s) {
    // Initialize a StringBuilder to efficiently build the sorted string
    StringBuilder sb = new StringBuilder();
    
    // Initialize an integer array to store the count of characters (ASCII values used as indices)
    int[] count = new int[128];

    // Iterate through each character in the input string s
    for (final char c : s.toCharArray())
      // Increment the count of the current character in the count array
      ++count[c];

    // Iterate through each character in the order string
    for (final char c : order.toCharArray())
      // Append the current character to the StringBuilder while decrementing its count to ensure proper sorting
      while (count[c]-- > 0)
        sb.append(c);

    // Iterate through lowercase English alphabet characters ('a' to 'z')
    for (char c = 'a'; c <= 'z'; ++c)
      // Append the current character to the StringBuilder while decrementing its count
      while (count[c]-- > 0)
        sb.append(c);

    // Convert the StringBuilder to a String and return the sorted result
    return sb.toString();
  }
}  
