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
  // Method to swap pairs in a linked list
  public ListNode swapPairs(ListNode head) {
    // Calculate the length of the linked list
    final int length = getLength(head);

    // Create a dummy node at the beginning of the list with value 0,
    // and its next points to the original head of the list
    ListNode dummy = new ListNode(0, head);
    // Initialize pointers: prev points to the node before the pair,
    // curr points to the first node of the pair, and next points to the node after the pair
    ListNode prev = dummy;
    ListNode curr = head;

    // Iterate through the linked list to swap pairs
    for (int i = 0; i < length / 2; ++i) {
      // Store the node after the current pair
      ListNode next = curr.next;
      
      // Perform the swap: adjust next, curr, and prev pointers
      curr.next = next.next;
      next.next = curr;
      prev.next = next;
      
      // Move pointers for the next iteration
      prev = curr;
      curr = curr.next;
    }

    // Return the next of the dummy node, which is the new head of the linked list
    return dummy.next;
  }

  // Helper method to calculate the length of the linked list
  private int getLength(ListNode head) {
    int length = 0;
    // Iterate through the linked list and count nodes
    for (ListNode curr = head; curr != null; curr = curr.next)
      ++length;
    // Return the calculated length
    return length;
  }
}
      
