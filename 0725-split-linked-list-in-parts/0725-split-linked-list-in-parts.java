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
    public ListNode[] splitListToParts(ListNode head, int k) {
         // Step 1: Find the total length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        
        // Step 2: Calculate the base size of each part and the number of parts with an extra node
        int partSize = length / k;  // base size of each part
        int extraNodes = length % k;  // number of extra nodes to distribute in the first few parts
        
        // Step 3: Initialize the result array
        ListNode[] result = new ListNode[k];
        current = head;
        
        // Step 4: Split the list into k parts
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;  // start of the current part
            int currentPartSize = partSize + (extraNodes > 0 ? 1 : 0);  // size of the current part
            extraNodes--;  // decrease the number of extra nodes for the next part
            
            // Traverse current part and disconnect from the rest of the list
            for (int j = 1; j < currentPartSize && current != null; j++) {
                current = current.next;
            }
            
            if (current != null) {
                ListNode nextPart = current.next;  // the next part will start from here
                current.next = null;  // break the link
                current = nextPart;  // move to the next part
            }
            
            result[i] = partHead;  // store the head of the current part in the result array
        }
        return result;
        
    }
}