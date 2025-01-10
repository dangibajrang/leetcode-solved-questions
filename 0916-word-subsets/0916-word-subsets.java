class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Initialize the list to store the result
        List<String> result = new ArrayList<>();
        
        // Create a frequency map to store the maximum character requirements from words2
        int[] maxFreq = new int[26];
        
        // Process each word in words2 to calculate the combined frequency requirement
        for (String word : words2) {
            // Get the character frequencies for the current word
            int[] wordFreq = getCharFrequency(word);
            
            // Update the maxFreq array to ensure it holds the maximum frequency of each character across words2
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], wordFreq[i]);
            }
        }
        
        // Iterate over each word in words1
        for (String word : words1) {
            // Get the character frequencies for the current word
            int[] wordFreq = getCharFrequency(word);
            
            // Check if the current word satisfies the maxFreq requirements
            if (isUniversal(wordFreq, maxFreq)) {
                // If it satisfies, add it to the result list
                result.add(word);
            }
        }
        
        // Return the list of universal strings
        return result;
    }
    
    // Helper method to calculate the frequency of each character in a word
    private int[] getCharFrequency(String word) {
        // Create an array to store character frequencies (for 'a' to 'z')
        int[] freq = new int[26];
        
        // Iterate over each character in the word
        for (char c : word.toCharArray()) {
            // Increment the frequency of the character
            freq[c - 'a']++;
        }
        
        // Return the frequency array
        return freq;
    }
    
    // Helper method to check if a word satisfies the maxFreq requirements
    private boolean isUniversal(int[] wordFreq, int[] maxFreq) {
        // Iterate over all 26 characters
        for (int i = 0; i < 26; i++) {
            // Check if the word's frequency for any character is less than the required frequency
            if (wordFreq[i] < maxFreq[i]) {
                // If not, the word is not universal
                return false;
            }
        }
        
        // If all frequency requirements are satisfied, return true
        return true;
    }
    
}
