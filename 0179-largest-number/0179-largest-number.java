class Solution {

    public static String largestNumber(int[] nums) {
        // Convert the integer array to a String array
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom comparator to compare two numbers based on their concatenation
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0" to handle cases like [0, 0]
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build the largest number by concatenating the sorted numbers
        StringBuilder largestNumber = new StringBuilder();
        for (String num : arr) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }

}
