class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;

        // Array to hold both plantTime and growTime for sorting
        int[][] seeds = new int[n][2];
        for (int i = 0; i < n; i++) {
            seeds[i][0] = plantTime[i];
            seeds[i][1] = growTime[i];
        }

        // Sort seeds based on growTime in descending order
        Arrays.sort(seeds, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        int currentDay = 0;
        int maxBloomDay = 0;

        // Plant each seed and calculate the bloom day
        for (int[] seed : seeds) {
            currentDay += seed[0]; // Increment current day by the plant time of this seed
            int bloomDay = currentDay + seed[1]; // Calculate bloom day for this seed
            maxBloomDay = Math.max(maxBloomDay, bloomDay); // Track the latest bloom day
        }

        return maxBloomDay;
    }

    // public static void main(String[] args) {
    //     Solution solution = new Solution();
    //     int[] plantTime1 = {1, 4, 3};
    //     int[] growTime1 = {2, 3, 1};
    //     System.out.println(solution.earliestFullBloom(plantTime1, growTime1)); // Output: 9

    //     int[] plantTime2 = {1, 2, 3, 2};
    //     int[] growTime2 = {2, 1, 2, 1};
    //     System.out.println(solution.earliestFullBloom(plantTime2, growTime2)); // Output: 9

    //     int[] plantTime3 = {1};
    //     int[] growTime3 = {1};
    //     System.out.println(solution.earliestFullBloom(plantTime3, growTime3)); // Output: 2
    // }
}
