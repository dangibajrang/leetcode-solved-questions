
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        // Split sentences into words
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        
        // Use HashMaps to count the frequency of each word
        Map<String, Integer> countA = new HashMap<>();
        Map<String, Integer> countB = new HashMap<>();
        
        for (String word : wordsA) {
            countA.put(word, countA.getOrDefault(word, 0) + 1);
        }
        
        for (String word : wordsB) {
            countB.put(word, countB.getOrDefault(word, 0) + 1);
        }
        
        // List to store uncommon words
        List<String> uncommon = new ArrayList<>();
        
        // Check for uncommon words in A
        for (String word : countA.keySet()) {
            if (countA.get(word) == 1 && !countB.containsKey(word)) {
                uncommon.add(word);
            }
        }
        
        // Check for uncommon words in B
        for (String word : countB.keySet()) {
            if (countB.get(word) == 1 && !countA.containsKey(word)) {
                uncommon.add(word);
            }
        }
        
        // Sort the uncommon words
        Collections.sort(uncommon);
        
        // Convert List to array
        return uncommon.toArray(new String[0]);
    }
}
