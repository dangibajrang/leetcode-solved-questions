class Solution {
    public String removeOccurrences(String s, String part) {
        // Loop until the substring 'part' is no longer found in 's'
        while (s.contains(part)) {
            // Replace the first occurrence of 'part' with an empty string
            s = s.replaceFirst(part, "");
        }
        // Return the final modified string
        return s;
    }
 
}
