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
  // Method to swap nodes at positions k from the beginning and end in a linked list
  public ListNode swapNodes(ListNode head, int k) {
    // Initialize pointers p and q to null
    ListNode p = null; // Points to the k-th node from the beginning
    ListNode q = null; // Points to the k-th node from the end

    // Iterate through the linked list
    for (ListNode curr = head; curr != null; curr = curr.next) {
      // If q is not null, move q to the next node
      if (q != null)
        q = q.next;
      
      // If k is not yet decremented to 0, decrement k
      if (--k == 0) {
        // Set p to the current node (k-th node from the beginning)
        p = curr;
        // Set q to the head (to start counting from the end)
        q = head;
      }
    }

    // Swap the values of nodes p and q
    final int temp = p.val;
    p.val = q.val;
    q.val = temp;

    // Return the head of the modified linked list
    return head;
  }
}
