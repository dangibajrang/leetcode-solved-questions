class Solution {
  public String toLowerCase(String str) {
    // Calculate the difference between ASCII values of uppercase 'A' and lowercase 'a'.
    final int diff = 'A' - 'a';

    // Convert the input string 'str' to a character array 'ans'.
    char[] ans = str.toCharArray();

    // Iterate through each character in the character array.
    for (int i = 0; i < ans.length; ++i) {
      // Check if the current character is an uppercase letter.
      if (ans[i] >= 'A' && ans[i] <= 'Z') {
        // If it is an uppercase letter, convert it to lowercase by subtracting the calculated difference.
        ans[i] -= diff;
      }
    }

    // Convert the modified character array back to a string and return it.
    return new String(ans);
  }
}
