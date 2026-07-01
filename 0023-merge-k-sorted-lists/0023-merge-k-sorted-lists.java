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
        if(lists==null || lists.length==0) return null;
        // minheap
        PriorityQueue<ListNode> pq =new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node:lists){
           if(node!=null) pq.offer(node);
        }
        if(pq.isEmpty()) return null;
        ListNode head=pq.poll();
        if(head.next!=null){
            pq.offer(head.next);
        }
        ListNode tail=head;
        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            tail.next=curr;
            tail=tail.next;
            if(curr.next!=null) {
                pq.offer(curr.next);
            }
        }
        return head;
    }
}












// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists==null || lists.length==0) return null;
//         ListNode head=lists[0];
//         for(int i=1;i<lists.length;i++){
//             head=mergeTwoList(head,lists[i]);
//         }
//         return head;
//     }
//     private ListNode mergeTwoList(ListNode l1,ListNode l2){
//         ListNode dummy=new ListNode(-1);
//         ListNode tail=dummy;
//         while(l1!=null && l2!=null){
//             if(l1.val<l2.val){
//                 tail.next=l1;
//                 l1=l1.next;
//             } else{
//                 tail.next=l2;
//                 l2=l2.next;
//             }
//             tail=tail.next;
//         }
//         if(l1!=null){
//             tail.next=l1;
//         }
//         if(l2!=null){
//             tail.next=l2;
//         }
//         return dummy.next;
//     }
// }