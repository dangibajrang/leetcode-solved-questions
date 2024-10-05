class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        // If s1 is larger than s2, it's impossible for s2 to contain a permutation of s1
        if (s1.length() > s2.length()) {
            return false;
        }

        // Arrays to store frequency counts of characters in s1 and the current window of s2
        int[] s1Freq = new int[26]; // Stores frequency of characters in s1
        int[] s2Freq = new int[26]; // Stores frequency of characters in the current window of s2

        // Fill the s1Freq array with the frequency of each character in s1
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++; // Initialize s2Freq with the first window of s2
        }

        // Now, we need to slide the window across s2 to check for permutations of s1
        for (int i = s1.length(); i < s2.length(); i++) {
            // If the frequency of the current window matches the frequency of s1, return true
            if (Arrays.equals(s1Freq, s2Freq)) {
                return true;
            }

            // Slide the window:
            // Add the current character to the window (expand the window)
            s2Freq[s2.charAt(i) - 'a']++;

            // Remove the character that's sliding out of the window (shrink the window)
            s2Freq[s2.charAt(i - s1.length()) - 'a']--;
        }

        // After the loop, check the last window
        return Arrays.equals(s1Freq, s2Freq);
    }
}
