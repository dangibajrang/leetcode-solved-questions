class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int count = 0;

        // Iterate through all pairs in the array
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j]; // Calculate product

                // If product exists, add its combination count to result
                if (productCount.containsKey(product)) {
                    int freq = productCount.get(product);
                    count += 8 * freq; // Each valid pair contributes 8 valid tuples
                }

                // Update product frequency in the map
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }
        return count;
    }

}
