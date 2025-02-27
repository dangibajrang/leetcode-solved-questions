class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        // Map to store the index of each number in the array
        Map<Integer, Integer> indexMap = new HashMap<>();
        int n = arr.length;
        // DP table to store the length of Fibonacci-like subsequence ending at indices (i, j)
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLength = 0;
        
        // Populate indexMap with array values and their corresponding indices
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        
        // Iterate over all pairs (j, k) in the array
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                // Compute the previous number needed to form Fibonacci sequence
                int a_i = arr[k] - arr[j];
                // Ensure the previous number is valid and is present in the array before index j
                if (a_i < arr[j] && indexMap.containsKey(a_i)) {
                    int i = indexMap.get(a_i);
                    // Compute the key for DP map
                    int key = i * n + j;
                    // Get previous length from dp map or initialize as 2 (base case)
                    int length = dp.getOrDefault(key, 2) + 1;
                    // Store new length in DP table
                    dp.put(j * n + k, length);
                    // Update the maximum length found so far
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        
        // If no valid Fibonacci subsequence found, return 0; otherwise, return maxLength
        return maxLength >= 3 ? maxLength : 0;
    }

}