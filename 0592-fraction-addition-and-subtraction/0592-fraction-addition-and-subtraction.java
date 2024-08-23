class Solution {
    public String fractionAddition(String expression) {
        // Initialize the numerator of the result to 0
        int numerator = 0;  
        
        // Initialize the denominator of the result to 1
        int denominator = 1;  
        
        // Start from the beginning of the expression string
        int i = 0;
        
        // Loop through the expression until the end
        while (i < expression.length()) {
            // Determine the sign of the current fraction (+ or -)
            int sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                // If the character is '-', set the sign to -1, otherwise, it remains 1
                sign = expression.charAt(i) == '-' ? -1 : 1;
                // Move to the next character
                i++;
            }
            
            // Start parsing the numerator part
            int numStart = i;
            while (expression.charAt(i) != '/') {
                // Continue moving until the '/' character is found
                i++;
            }
            // Convert the parsed string to an integer (current numerator)
            int currentNumerator = Integer.parseInt(expression.substring(numStart, i));
            // Move to the next character (after '/')
            i++;
            
            // Start parsing the denominator part
            int denStart = i;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                // Continue moving until a non-digit character is found or end of the string
                i++;
            }
            // Convert the parsed string to an integer (current denominator)
            int currentDenominator = Integer.parseInt(expression.substring(denStart, i));
            
            // Update the numerator by adding/subtracting the fraction using a common denominator
            numerator = numerator * currentDenominator + sign * currentNumerator * denominator;
            // Update the denominator by multiplying with the current denominator
            denominator *= currentDenominator;
            
            // Simplify the fraction by dividing both the numerator and denominator by their GCD
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        // If the numerator is 0, return "0/1" as the result
        if (numerator == 0) {
            return "0/1";
        }
        
        // Return the final fraction in the form of "numerator/denominator"
        return numerator + "/" + denominator;
    }
    
    // Helper method to calculate the Greatest Common Divisor (GCD) using the Euclidean algorithm
    private int gcd(int a, int b) {
        // Continue until b becomes 0
        while (b != 0) {
            // Temporary storage of b
            int temp = b;
            // Assign the remainder of a divided by b to b
            b = a % b;
            // Assign temp (old b) to a
            a = temp;
        }
        // Return the greatest common divisor
        return a;
    }
}
