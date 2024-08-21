// class Solution {
//   public int findDuplicate(int[] nums) { 
//     int slow = nums[nums[0]]; // Initialize slow pointer to the value at index nums[0]
//     int fast = nums[nums[nums[0]]]; // Initialize fast pointer to the value at index nums[nums[0]]

//     while (slow != fast) { // Start loop until slow and fast pointers meet
//       slow = nums[slow]; // Move slow pointer one step forward
//       fast = nums[nums[fast]]; // Move fast pointer two steps forward
//     }

//     slow = nums[0]; // Reset slow pointer to the beginning of the array

//     while (slow != fast) { // Loop until slow and fast pointers meet again
//       slow = nums[slow]; // Move slow pointer one step forward
//       fast = nums[fast]; // Move fast pointer one step forward
//     }

//     return slow; // Return the value where slow and fast pointers meet, indicating the duplicate number
//   }
// }



public class Solution {
    public int findDuplicate(int[] nums) {
        // Initialize both tortoise and hare to the first element of the array
        int tortoise = nums[0];
        int hare = nums[0];
        
        // Phase 1: Detect the cycle
        do {
            // Move tortoise one step ahead in the array
            tortoise = nums[tortoise];
            // Move hare two steps ahead in the array
            hare = nums[nums[hare]];
        // Continue until both pointers meet inside the cycle
        } while (tortoise != hare);
        
        // Phase 2: Find the entry point of the cycle (the duplicate number)
        // Reset tortoise to the start of the array
        tortoise = nums[0];
        // Move both tortoise and hare one step at a time until they meet
        while (tortoise != hare) {
            // Move tortoise one step ahead
            tortoise = nums[tortoise];
            // Move hare one step ahead
            hare = nums[hare];
        }
        
        // The meeting point is the start of the cycle, which is the duplicate number
        return hare;
    }
}
