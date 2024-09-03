public class Solution {
    public int getLucky(String s, int k) {
        // Step 1: Convert the string to its corresponding digit string
        StringBuilder digits = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int num = ch - 'a' + 1; // convert character to its position in the alphabet
            digits.append(num); // append the number to the digit string
        }

        // Step 2: Perform k transformations
        int sum = 0;
        for (char digit : digits.toString().toCharArray()) {
            sum += digit - '0'; // convert character to integer and sum them up
        }

        // Step 3: Repeat the transformation for k iterations
        for (int i = 1; i < k; i++) {
            int newSum = 0;
            while (sum > 0) {
                newSum += sum % 10; // add each digit of the current sum
                sum /= 10;
            }
            sum = newSum;
        }

        return sum;
    }
}
