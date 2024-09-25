
// class Solution {
//   public String replaceWords(List<String> dictionary, String sentence) {
//     Set<String> dict = new HashSet<>(dictionary);
//     String[] words = sentence.split(" ");
//     StringBuilder sb = new StringBuilder();

//     for (String word : words) {
//       String prefix = "";
//       for (int i = 1; i <= word.length(); i++) {
//         prefix = word.substring(0, i);
//         if (dict.contains(prefix)) {
//           break;
//         }
//       }
//       if (sb.length() > 0) {
//         sb.append(" ");
//       }
//       sb.append(dict.contains(prefix) ? prefix : word);
//     }

//     return sb.toString();
//   }
// }



//using trie


import java.util.List;
import java.util.ArrayList;

// Define the TrieNode class to represent each node in the Trie
class TrieNode {
    TrieNode[] children; // Array to store references to child nodes (26 lowercase letters)
    boolean isEndOfWord; // Boolean flag to indicate if this node marks the end of a word

    // Constructor to initialize a Trie node
    public TrieNode() {
        children = new TrieNode[26]; // Create an array for 26 lowercase letters
        isEndOfWord = false;          // By default, this is not the end of a word
    }
}

// Define the ReplaceWords class that utilizes Trie to store roots
class Solution {
    private TrieNode root; // Root node of the Trie

    // Constructor to initialize the ReplaceWords with an empty root node
    public Solution() {
        root = new TrieNode();
    }

    // Method to add a root to the Trie
    public void addRoot(String rootWord) {
        TrieNode currentNode = root; // Start from the root node
        for (char ch : rootWord.toCharArray()) { // Iterate over each character in the root
            int index = ch - 'a'; // Get the index of the character in the alphabet (0-25)
            if (currentNode.children[index] == null) { // If the child node doesn't exist, create it
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index]; // Move to the next node
        }
        currentNode.isEndOfWord = true; // Mark the last node as the end of the root
    }

    // Method to find the root for a given word using the Trie
    public String findRoot(String word) {
        TrieNode currentNode = root; // Start from the root node
        StringBuilder rootWord = new StringBuilder(); // To build the root word

        for (char ch : word.toCharArray()) { // Iterate over each character in the word
            int index = ch - 'a'; // Get the index of the character
            if (currentNode.children[index] == null) { // If the child node doesn't exist, stop searching
                break; 
            }
            rootWord.append(ch); // Append the character to the rootWord
            currentNode = currentNode.children[index]; // Move to the next node

            // If we reach the end of a root, return the root found
            if (currentNode.isEndOfWord) {
                return rootWord.toString();
            }
        }
        return word; // If no root is found, return the original word
    }

    // Method to replace words in the sentence using the roots in the Trie
    public String replaceWords(List<String> roots, String sentence) {
        // Add all roots to the Trie
        for (String root : roots) {
            addRoot(root);
        }

        StringBuilder result = new StringBuilder(); // To store the final sentence
        String[] words = sentence.split(" "); // Split the sentence into words

        for (String word : words) { // Iterate over each word in the sentence
            if (result.length() > 0) {
                result.append(" "); // Append space before adding the next word
            }
            // Find and append the root or the original word
            result.append(findRoot(word));
        }

        return result.toString(); // Return the final modified sentence
    }
}

// Main class for testing the ReplaceWords implementation
// public class Main {
//     public static void main(String[] args) {
//         ReplaceWords replaceWords = new ReplaceWords(); // Create a ReplaceWords instance
        
//         // Define roots
//         List<String> roots = new ArrayList<>();
//         roots.add("cat");
//         roots.add("bat");
//         roots.add("rat");
        
//         // Define the sentence
//         String sentence = "the cattle was rattled by the battery";
        
//         // Call the replaceWords method and print the result
//         String result = replaceWords.replaceWords(roots, sentence);
//         System.out.println(result); // Output: "the cat was rat by the bat"
//     }
//}

