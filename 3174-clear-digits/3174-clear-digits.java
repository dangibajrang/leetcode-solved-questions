class Solution {
    public String clearDigits(String s) {
        // Initialize a StringBuilder to build the resulting string
        StringBuilder result = new StringBuilder();

        // Iterate over each character in the input string
        for (char ch : s.toCharArray()) {
            // Check if the current character is a digit
            if (Character.isDigit(ch)) {
                // If the result is not empty, remove the last character
                // This simulates deleting the closest non-digit character to the left
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                // If the current character is not a digit, append it to the result
                result.append(ch);
            }
        }

        // Convert the StringBuilder to a String and return the result
        return result.toString();
    }
}
