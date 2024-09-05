class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // Step 1: Calculate the total sum required for m + n observations
        int m = rolls.length;
        int totalSum = mean * (m + n);

        // Step 2: Calculate the current sum of rolls
        int sumOfRolls = 0;
        for (int roll : rolls) {
            sumOfRolls += roll;
        }

        // Step 3: Calculate the missing sum that the n observations should make up
        int missingSum = totalSum - sumOfRolls;

        // Step 4: Check if it's possible to distribute the missing sum
        if (missingSum < n || missingSum > 6 * n) {
            // If not possible, return an empty array
            return new int[0];
        }

        // Step 5: Greedily distribute the missing sum
        int[] result = new int[n];
        Arrays.fill(result, missingSum / n);  // Fill with the base value

        int remainder = missingSum % n;  // Distribute the remainder

        for (int i = 0; i < remainder; i++) {
            result[i]++;
        }

        return result;
    }
}
