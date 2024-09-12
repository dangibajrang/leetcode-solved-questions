class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
         // Create a set of allowed characters for fast lookup
        HashSet<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        int consistentCount = 0;

        // Iterate through each word
        for (String word : words) {
            boolean isConsistent = true;

            // Check if the word only contains allowed characters
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }

            // If the word is consistent, increment the count
            if (isConsistent) {
                consistentCount++;
            }
        }

        return consistentCount;
    }
}