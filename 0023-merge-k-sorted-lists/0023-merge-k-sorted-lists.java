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
    public ListNode mergeKLists(ListNode[] lists) {
        //Define the min heap
        Queue<ListNode> minHeap = new PriorityQueue<>((a,b)-> a.val - b.val);
        
        for(ListNode node : lists){
            if(node == null) continue;
            minHeap.add(node);
        }
        
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        
        while(!minHeap.isEmpty()){
            ListNode top = minHeap.poll();
            cur.next = top;
            cur = cur.next;
            if(top.next != null){
                minHeap.add(top.next);
            }
        }
        return dummy.next;
    }
}