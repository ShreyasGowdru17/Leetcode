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
import java.util.PriorityQueue;
class Solution {
    public ListNode mergeKLists(ListNode[] lists){
        if(lists==null || lists.length==0){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        PriorityQueue<ListNode> heap=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));

        for(ListNode list:lists){
            if(list!=null){
                heap.offer(list);
            }
        }

        while(!heap.isEmpty()){
            ListNode smallest=heap.poll();
            temp.next=smallest;
            temp=temp.next;
             if(smallest.next!=null){
                heap.offer(smallest.next);
             }

        }
        return dummy.next;
    }
    /*public ListNode mergeList(ListNode head1,ListNode head2){
        ListNode temp1=head1;
        ListNode temp2=head2;
        ListNode dummy=new ListNode(-1,null);
        ListNode temp=dummy;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next=temp1;
                temp1=temp1.next;
            }
            else{
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if(temp1!=null){
            temp.next=temp1;
        }
        if(temp2!=null){
            temp.next=temp2;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        ListNode head=lists[0];
        for(int i=1;i<lists.length;i++){
            head=mergeList(head,lists[i]);
        }
        return head;
    }*/
}