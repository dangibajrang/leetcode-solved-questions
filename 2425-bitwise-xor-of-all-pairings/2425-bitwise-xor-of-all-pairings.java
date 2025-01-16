class Solution {
  public int xorAllNums(int[] nums1, int[] nums2) {
    // Initialize variables to store the XOR of all elements in nums1 and nums2
    int xors1 = 0; // XOR result of nums1
    int xors2 = 0; // XOR result of nums2

    // Calculate the XOR of all elements in nums1
    for (int num : nums1) {
      xors1 ^= num; // XOR each number in nums1
    }

    // Calculate the XOR of all elements in nums2
    for (int num : nums2) {
      xors2 ^= num; // XOR each number in nums2
    }

    // If nums1 has an odd length, each element of nums2 is repeated nums1.length times
    // Thus, XOR all elements of nums2 (xors2) with the result
    int resultFromNums1 = (nums1.length % 2 == 1) ? xors2 : 0;

    // If nums2 has an odd length, each element of nums1 is repeated nums2.length times
    // Thus, XOR all elements of nums1 (xors1) with the result
    int resultFromNums2 = (nums2.length % 2 == 1) ? xors1 : 0;

    // XOR the results to get the final answer
    return resultFromNums1 ^ resultFromNums2;
  }
}
