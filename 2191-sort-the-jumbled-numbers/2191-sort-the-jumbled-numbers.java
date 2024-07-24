class Solution {
    // Function to return the mapped value of a number as per the given mapping
    private int getMappedValue(int num, int[] mapping) {
        String numStr = String.valueOf(num);
        StringBuilder mappedStr = new StringBuilder();

        // Replace each digit with its corresponding mapped value
        for (char digit : numStr.toCharArray()) {
            mappedStr.append(mapping[digit - '0']);
        }

        // Convert the mapped string back to an integer
        return Integer.parseInt(mappedStr.toString());
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Create an array of pairs (original number, mapped value)
        int[][] pairs = new int[nums.length][2];
        
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i]; // Original number
            pairs[i][1] = getMappedValue(nums[i], mapping); // Mapped value
        }
        
        // Sort the pairs based on the mapped values, maintaining relative order for same values
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return 0; // Maintain relative order for same mapped values
            }
        });

        // Extract the sorted original numbers
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = pairs[i][0];
        }

        return sortedNums;
    }
}
