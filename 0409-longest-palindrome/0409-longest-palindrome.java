class Solution {
  public int longestPalindrome(String s) {
    int ans = 0;
    // Array to store the count of each character (assuming ASCII)
    int[] count = new int[128];

    // Count the frequency of each character in the string
    for (char c : s.toCharArray()) {
      count[c]++;
    }

    // Add the even counts directly to the answer
    // For odd counts, add the largest even number less than the count
    for (int freq : count) {
      ans += freq / 2 * 2;
    }

    // Check if there is any character with an odd count
    boolean hasOddCount = Arrays.stream(count).anyMatch(freq -> freq % 2 == 1);
    
    // If there is any odd count, we can place one odd character in the middle of the palindrome
    return ans + (hasOddCount ? 1 : 0);
  }
}