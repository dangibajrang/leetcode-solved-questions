class Solution {
  // Method to determine the number of different light patterns achievable
  // given the number of lights (n) and the number of flips allowed (m)
  public int flipLights(int n, int m) {
    // Restrict the value of n to be at most 3
    n = Math.min(n, 3);

    // If no flips are allowed, only one pattern is possible (all lights on)
    if (m == 0)
      return 1;
    
    // If one flip is allowed, return the number of possible patterns based on n
    if (m == 1)
      return new int[] {2, 3, 4}[n - 1]; // Different possibilities for each value of n

    // If two flips are allowed, return the number of possible patterns based on n
    if (m == 2)
      return new int[] {2, 4, 7}[n - 1]; // Different possibilities for each value of n

    // If more than two flips are allowed, all possible patterns are achievable,
    // thus return 2^n, where n is the number of lights
    return (int) Math.pow(2, n);
  }
}
