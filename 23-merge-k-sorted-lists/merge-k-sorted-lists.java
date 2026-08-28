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
        if(lists==null||lists.length==0)return null;
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode l:lists){
            if(l!=null){
                pq.add(l);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(!pq.isEmpty()){
            ListNode small=pq.poll();
            curr.next=small;
            curr=curr.next;
            if(small.next!=null){
                pq.add(small.next);
            }
        }
        return dummy.next;
    }
}