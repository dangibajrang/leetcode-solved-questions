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
    public boolean hasCycle(ListNode head) {
        // Initialize two pointers: tortoise and hare
        ListNode tortoise = head;
        ListNode hare = head;
        
        // Traverse the list with two pointers
        while (hare != null && hare.next != null) {
            // Move tortoise one step
            tortoise = tortoise.next;
            // Move hare two steps
            hare = hare.next.next;
            
            // If the two pointers meet, a cycle exists
            if (tortoise == hare) {
                return true;
            }
        }
        
        // If the end of the list is reached, no cycle exists
        return false;
    }
}
