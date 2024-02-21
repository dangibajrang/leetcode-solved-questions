class Solution {
  public int arraySign(int[] nums) {
    // Initialize the sign to positive
    int sign = 1;

    // Iterate through each element in the array
    for (final int num : nums) {
      // If the current element is zero, return 0
      if (num == 0)
        return 0;
      
      // If the current element is negative, flip the sign
      if (num < 0)
        sign = -sign;
    }

    // If the loop completes without encountering zero, return the final sign
    return sign;
  }
}
