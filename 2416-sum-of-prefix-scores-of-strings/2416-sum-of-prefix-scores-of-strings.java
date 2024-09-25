
class TrieNode {
    TrieNode[] children;  // Array to store the next characters
    int count;            // To count the number of strings that have passed through this node

    public TrieNode() {
        children = new TrieNode[26];  // 26 letters in the English alphabet
        count = 0;                    // Initialize count to 0
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();  // Initialize the root of the Trie
    }
    
    // Insert a string into the Trie and update prefix counts
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';  // Calculate the index (0-25) for the current character
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();  // Create a new node if it doesn't exist
            }
            node = node.children[index];
            node.count++;  // Increment count to reflect this prefix has been encountered
        }
    }
    
    // Calculate the prefix score for a given string
    public int getPrefixScore(String word) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            int index = c - 'a';  // Calculate the index (0-25) for the current character
            node = node.children[index];
            score += node.count;  // Add the count at this node to the score
        }
        return score;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();  // Create a Trie
        int n = words.length;
        int[] result = new int[n];  // Array to store the result
        
        // Step 1: Insert all words into the Trie
        for (String word : words) {
            trie.insert(word);
        }
        
        // Step 2: Calculate prefix scores for each word
        for (int i = 0; i < n; i++) {
            result[i] = trie.getPrefixScore(words[i]);
        }
        
        return result;
    }

}
