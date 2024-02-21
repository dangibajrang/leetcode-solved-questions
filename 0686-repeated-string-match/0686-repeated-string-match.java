class Solution {
  public int repeatedStringMatch(String A, String B) {
    // Calculate the minimum number of times A needs to be repeated to cover B
    final int n = (int) Math.ceil((double) B.length() / (double) A.length());
    
    // Repeat string A 'n' times using Collections.nCopies and join them into a single string
    final String s = String.join("", Collections.nCopies(n, A));

    // Check if the repeated string contains B
    if (s.contains(B))
      return n;

    // Check if adding one more repetition of A to the string makes it contain B
    if ((s + A).contains(B))
      return n + 1;

    // If B cannot be formed by repeating A, return -1
    return -1;
  }
}
