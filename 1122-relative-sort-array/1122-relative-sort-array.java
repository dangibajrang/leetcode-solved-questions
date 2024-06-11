class Solution {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    // Array to store the result
    int[] result = new int[arr1.length];
    
    // Array to count occurrences of each number in arr1
    int[] count = new int[1001];
    
    // Index for filling the result array
    int index = 0;

    // Count each number in arr1
    for (int num : arr1) {
      count[num]++;
    }

    // Place the numbers from arr2 in result, in order
    for (int num : arr2) {
      while (count[num] > 0) {
        result[index++] = num;
        count[num]--;
      }
    }

    // Place the remaining numbers in sorted order
    for (int num = 0; num < 1001; num++) {
      while (count[num] > 0) {
        result[index++] = num;
        count[num]--;
      }
    }

    return result;
  }
}
