/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Initialize two pointers: tortoise and hare
        ListNode tortoise = head;
        ListNode hare = head;
        
        // Phase 1: Detect the cycle
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            
            // If a cycle is detected
            if (tortoise == hare) {
                // Phase 2: Find the start of the cycle
                ListNode start = head;
                while (start != tortoise) {
                    start = start.next;
                    tortoise = tortoise.next;
                }
                // Return the start of the cycle
                return start;
            }
        }
        
        // If no cycle is detected
        return null;
    }
}
