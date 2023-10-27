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

//  1st approach
// class Solution {
//     public boolean isPalindrome(ListNode head) {

//          //base case 
//         if(head == null || head.next == null) return true;
        
//         //define slow and fast
//         ListNode slow = head, fast = head;
        
//         //move slow and fast in the right position
//         while(fast != null && fast.next != null){
//             slow = slow.next;
//             fast = fast.next.next;
//         }
        
//         //reverse the last half of the list
//         ListNode L = head, R = reverse(slow);
        
//         //check if is palindrome
//         while(R != null){
//             if(L.val == R.val){
//                 L = L.next;
//                 R = R.next;
//             }else{ 
//                 return false;
//             }
//         }
        
//         return true;
//     }
//     private ListNode reverse(ListNode head){
//         // base case
//         if(head == null || head.next == null) return head;
        
//         //reverse
//         ListNode pre = null, cur = head;
//         while(cur != null){
//             ListNode temp = cur.next;
//             cur.next = pre;
//             pre = cur;
//             cur = temp;
//         }
//         return pre;
        
//     }
// }


// 2nd approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
