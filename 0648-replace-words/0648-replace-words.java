import java.util.*;

class Solution {
  public String replaceWords(List<String> dictionary, String sentence) {
    Set<String> dict = new HashSet<>(dictionary);
    String[] words = sentence.split(" ");
    StringBuilder sb = new StringBuilder();

    for (String word : words) {
      String prefix = "";
      for (int i = 1; i <= word.length(); i++) {
        prefix = word.substring(0, i);
        if (dict.contains(prefix)) {
          break;
        }
      }
      if (sb.length() > 0) {
        sb.append(" ");
      }
      sb.append(dict.contains(prefix) ? prefix : word);
    }

    return sb.toString();
  }

//   public static void main(String[] args) {
//     Solution solution = new Solution();
//     List<String> dictionary = Arrays.asList("cat", "bat", "rat");
//     String sentence = "the cattle was rattled by the battery";
//     String result = solution.replaceWords(dictionary, sentence);
//     System.out.println(result); // Outputs: "the cat was rat by the bat"
//   }
}
