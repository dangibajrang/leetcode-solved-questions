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
    public ListNode partition(ListNode head, int x) {
         //Base case
        if(head == null || head.next == null) return head;
        
        ListNode dummyMin = new ListNode(), dummyMax = new ListNode();
        ListNode min = dummyMin, max = dummyMax;
        
        //Traverse the list
        while(head != null){
            if(head.val < x){
                min.next = head;
                min = min.next;
            }else{
                max.next = head;
                max = max.next;
            }
            head = head.next;
        }
        
        //merge two sub lists
        min.next = dummyMax.next;
        max.next = null;
        return dummyMin.next;
        
    }
}