class Solution {
  public boolean repeatedSubstringPattern(String s) {
    // Concatenate the input string with itself
    final String ss = s + s;
    
    // Check if a substring excluding the first and last characters of ss contains the original string s
    return ss.substring(1, ss.length() - 1).contains(s);
  }
}

