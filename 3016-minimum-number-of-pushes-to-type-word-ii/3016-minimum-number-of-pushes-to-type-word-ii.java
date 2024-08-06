
class Solution {
    // Method to calculate the minimum number of key pushes to type the given word
    public int minimumPushes(String word) {
        // Array to count the frequency of each letter in the word
        int[] count = new int[26];
        
        // Iterate over each character in the word
        for (char c : word.toCharArray()) {
            // Increment the count for the corresponding letter
            count[c - 'a']++;
        }
        
        // Sort the frequency array in ascending order
        Arrays.sort(count);
        
        // Variable to store the total number of pushes required
        int pushes = 0;
        
        // Iterate over the frequency array from the highest frequency to the lowest
        for (int i = 0; i < 26; ++i) {
            // Calculate the total pushes by assigning higher frequencies to lower key presses
            pushes += count[25 - i] * (i / 8 + 1);
        }
        
        // Return the total number of key pushes
        return pushes;
    }
}
