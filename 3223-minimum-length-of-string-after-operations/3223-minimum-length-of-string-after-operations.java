// class Solution {
//   public int minimumLength(String s) {
//     int ans = 0;
//     int[] count = new int[26];

//     for (final char c : s.toCharArray())
//       ++count[c - 'a'];

//     for (int i = 0; i < 26; ++i)
//       if (count[i] > 0)
//         ans += count[i] % 2 == 0 ? 2 : 1;

//     return ans;
//   }
// }

class Solution {
    // Define the method minimumLength that takes a string s and returns an integer.
    public int minimumLength(String s) {
        // Initialize a HashMap to store the count of each character in the string.
        HashMap<Character, Integer> count = new HashMap<>();
        
        // Iterate through each character in the string, updating the count in the HashMap.
        for (char c : s.toCharArray()) 
            // Increment the count of the character or initialize it to 1 if it doesn't exist yet.
            count.put(c, count.getOrDefault(c, 0) + 1);
        
        // Initialize a variable 'minus' to keep track of the number of characters to remove.
        int minus = 0;
        
        // Iterate through the values (counts) of the characters in the HashMap.
        for (int value : count.values()) {
            // While the count of a character is 3 or more, perform the removal logic.
            while (value >= 3) {
                // Reduce the string length by 2 for each character removed (since 3 or more characters are removed in pairs).
                minus += 2;
                // Decrease the count of the character by 2.
                value -= 2;
            }
        }
        
        // Return the length of the string minus the number of characters removed (stored in 'minus').
        return s.length() - minus;
    }
}
