class Solution {
  public int findDuplicate(int[] nums) { 
    int slow = nums[nums[0]]; // Initialize slow pointer to the value at index nums[0]
    int fast = nums[nums[nums[0]]]; // Initialize fast pointer to the value at index nums[nums[0]]

    while (slow != fast) { // Start loop until slow and fast pointers meet
      slow = nums[slow]; // Move slow pointer one step forward
      fast = nums[nums[fast]]; // Move fast pointer two steps forward
    }

    slow = nums[0]; // Reset slow pointer to the beginning of the array

    while (slow != fast) { // Loop until slow and fast pointers meet again
      slow = nums[slow]; // Move slow pointer one step forward
      fast = nums[fast]; // Move fast pointer one step forward
    }

    return slow; // Return the value where slow and fast pointers meet, indicating the duplicate number
  }
}
