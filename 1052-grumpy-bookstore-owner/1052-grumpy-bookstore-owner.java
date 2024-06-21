class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int totalSatisfied = 0;
        int maxAdditionalCustomers = 0;
        int currentAdditionalCustomers = 0;

        // Calculate total satisfied customers without being grumpy and max additional customers
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            } else {
                currentAdditionalCustomers += customers[i];
            }

            // Keep current window size at most X
            if (i >= X) {
                if (grumpy[i - X] == 1) {
                    currentAdditionalCustomers -= customers[i - X];
                }
            }

            // Update max additional customers
            if (i >= X - 1) {
                maxAdditionalCustomers = Math.max(maxAdditionalCustomers, currentAdditionalCustomers);
            }
        }

        return totalSatisfied + maxAdditionalCustomers;
    }
}



