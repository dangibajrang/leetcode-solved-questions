

class Solution {
    public String nearestPalindromic(String n) {
        int length = n.length();
        long originalNumber = Long.parseLong(n);
        Set<Long> candidates = new HashSet<>();

        // Edge cases: numbers like "1", "10", "100", etc.
        candidates.add((long)Math.pow(10, length) + 1); // 100...001
        candidates.add((long)Math.pow(10, length - 1) - 1); // 999...999

        // Extract the prefix: the first half of the number
        long prefix = Long.parseLong(n.substring(0, (length + 1) / 2));

        // Generate palindromic candidates by manipulating the prefix
        for (long i = -1; i <= 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(prefix + i);
            String firstHalf = sb.toString();
            String candidate;
            if (length % 2 == 0) {
                candidate = firstHalf + new StringBuilder(firstHalf).reverse().toString();
            } else {
                candidate = firstHalf + new StringBuilder(firstHalf.substring(0, firstHalf.length() - 1)).reverse().toString();
            }
            candidates.add(Long.parseLong(candidate));
        }

        // Remove the original number to avoid considering it as a palindrome
        candidates.remove(originalNumber);

        // Find the closest palindrome
        long closest = -1;
        for (long candidate : candidates) {
            if (closest == -1 || Math.abs(candidate - originalNumber) < Math.abs(closest - originalNumber) ||
                (Math.abs(candidate - originalNumber) == Math.abs(closest - originalNumber) && candidate < closest)) {
                closest = candidate;
            }
        }

        return String.valueOf(closest);
    }
}
