/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
  public ListNode removeZeroSumSublists(ListNode head) {
    
    // Create a dummy node with value 0 and set its next to the head of the given list
    ListNode dummy = new ListNode(0, head);
    
    // Initialize a variable to keep track of the running sum (prefix sum)
    int prefix = 0;
    
    // Create a HashMap to store the prefix sum along with the corresponding node
    Map<Integer, ListNode> prefixToNode = new HashMap<>();
    // Initialize the HashMap with the initial prefix sum of 0 and the dummy node
    prefixToNode.put(0, dummy);

    // Iterate through the linked list to calculate and store the prefix sums
    for (; head != null; head = head.next) {
      // Update the prefix sum
      prefix += head.val;
      // Store the current prefix sum and the corresponding node in the HashMap
      prefixToNode.put(prefix, head);
    }

    // Reset the prefix sum to 0
    prefix = 0;

    // Iterate through the linked list again to remove zero-sum sublists
    for (head = dummy; head != null; head = head.next) {
      // Update the prefix sum
      prefix += head.val;
      // Set the next node of the current node to the next node of the corresponding prefix sum node
      head.next = prefixToNode.get(prefix).next;
    }

    // Return the modified linked list starting from the next of the dummy node
    return dummy.next;
  }
}
