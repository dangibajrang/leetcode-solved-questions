class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // If the total number of flowers needed is more than available, it's impossible
        if (m * k > bloomDay.length) {
            return -1;
        }

        // Find the minimum and maximum days in bloomDay
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }

        // Binary search to find the minimum number of days required
        int left = minDay;
        int right = maxDay;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Final check to ensure the minimum day found can make the required bouquets
        return canMakeBouquets(bloomDay, left, m, k) ? left : -1;
    }

    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
            if (bouquets >= m) {
                return true;
            }
        }
        return false;
    }
}

// Example usage:
// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int[] bloomDay1 = {1, 10, 3, 10, 2};
//         System.out.println(sol.minDays(bloomDay1, 3, 1)); // Output: 3

//         int[] bloomDay2 = {1, 10, 3, 10, 2};
//         System.out.println(sol.minDays(bloomDay2, 3, 2)); // Output: -1

//         int[] bloomDay3 = {7, 7, 7, 7, 12, 7, 7};
//         System.out.println(sol.minDays(bloomDay3, 2, 3)); // Output: 12
//     }
//}
