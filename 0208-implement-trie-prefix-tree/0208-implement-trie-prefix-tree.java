// Define the TrieNode class to represent each node in the Trie
class TrieNode {
    // Array to store references to child nodes (26 lowercase letters)
    TrieNode[] children;
    
    // Boolean flag to indicate if this node marks the end of a word
    boolean isEndOfWord;

    // Constructor to initialize a Trie node
    public TrieNode() {
        children = new TrieNode[26]; // Create an array for 26 lowercase letters
        isEndOfWord = false;         // By default, this is not the end of a word
    }
}

// Define the Trie class to implement the Trie structure
class Trie {
    // Root node of the Trie
    private TrieNode root;

    // Constructor to initialize the Trie with an empty root node
    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode currentNode = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) { // Iterate over each character in the word
            int index = word.charAt(i) - 'a';    // Get the index of the character in the alphabet (0-25)
            if (currentNode.children[index] == null) { // If the child node doesn't exist, create it
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index]; // Move to the next node
        }
        currentNode.isEndOfWord = true; // Mark the last node as the end of the word
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode currentNode = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) { // Iterate over each character in the word
            int index = word.charAt(i) - 'a';    // Get the index of the character in the alphabet (0-25)
            if (currentNode.children[index] == null) { // If the child node doesn't exist, the word is not in the Trie
                return false;
            }
            currentNode = currentNode.children[index]; // Move to the next node
        }
        return currentNode.isEndOfWord; // Return true only if this node marks the end of the word
    }

    // Check if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root; // Start from the root node
        for (int i = 0; i < prefix.length(); i++) { // Iterate over each character in the prefix
            int index = prefix.charAt(i) - 'a';    // Get the index of the character in the alphabet (0-25)
            if (currentNode.children[index] == null) { // If the child node doesn't exist, the prefix is not in the Trie
                return false;
            }
            currentNode = currentNode.children[index]; // Move to the next node
        }
        return true; // If the entire prefix was found, return true
    }


}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */