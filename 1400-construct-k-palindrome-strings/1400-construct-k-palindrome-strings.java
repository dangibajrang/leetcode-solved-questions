class Solution {
    public boolean canConstruct(String s, int k) {
          // If the number of palindromes required is greater than the length of the string,
        // it's impossible to construct k palindromes.
        if (k > s.length()) {
            return false;
        }

        // Create an array to count the frequency of each character in the string.
        int[] charCount = new int[26];

        // Iterate through the string and count the occurrences of each character.
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Count how many characters have an odd frequency.
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // To construct k palindromes, the number of odd frequency characters must
        // not exceed k (because each odd character needs its own palindrome).
        return oddCount <= k;
    }
}