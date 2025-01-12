class Solution {
    public boolean canBeValid(String s, String locked) {
        // If the length of the string is odd, it's impossible to balance
        if (s.length() % 2 == 1)
            return false;

        // Check both forward and reverse directions for validity
        return check(s, locked, true) && check(s, locked, false);
    }

    private boolean check(final String s, final String locked, boolean isForward) {
        int changeable = 0; // Count of changeable positions ('0' in locked)
        int open = 0;       // Count of open parentheses '('
        int close = 0;      // Count of close parentheses ')'

        // Loop through the string in forward or reverse direction
        for (int i = 0; i < s.length(); ++i) {
            // Calculate index based on the direction
            int idx = isForward ? i : s.length() - 1 - i;

            // Get current character and lock status
            final char c = s.charAt(idx);
            final char lock = locked.charAt(idx);

            if (lock == '0') {
                // Increment changeable count if the position is unlockable
                ++changeable;
            } else if (c == '(') {
                // Increment open count for '('
                ++open;
            } else {
                // Increment close count for ')'
                ++close;
            }

            // Check imbalance conditions based on the direction
            if (isForward && close > open + changeable) {
                return false; // Too many ')' to balance with '(' or changeables
            }
            if (!isForward && open > close + changeable) {
                return false; // Too many '(' to balance with ')' or changeables
            }
        }

        // If we reach here, the string is balanced in the given direction
        return true;
    }
}
