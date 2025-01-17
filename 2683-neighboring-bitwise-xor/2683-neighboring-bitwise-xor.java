
class Solution {
  public boolean doesValidArrayExist(int[] derived) {
    // Step 1: Calculate the XOR of all elements in the derived array.
    // If the XOR of all elements is 0, it means a valid original array exists.
    int xorSum = 0; // Initialize XOR sum to 0.
    for (int num : derived) { // Loop through each element in the derived array.
      xorSum ^= num; // Compute the cumulative XOR.
    }

    // Step 2: Return true if XOR of all elements is 0, otherwise return false.
    return xorSum == 0; // A valid original array exists if XOR of derived is 0.
  }
}
