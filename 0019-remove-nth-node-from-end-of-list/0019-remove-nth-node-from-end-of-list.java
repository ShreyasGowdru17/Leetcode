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
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode prev=null;
         ListNode cur=head;
         int count=countNodes(head);
         if(head.next==null){
            head=null;
            return head;
         }
         if(count==n){
            head=head.next;
            return head;
         }
         int last=count-n;
         int pos=1;
         while(pos<=last){
            pos+=1;
            prev=cur;
            cur=cur.next;
         }
         prev.next=cur.next;
         cur.next=null;
         return head;
    }
    public int countNodes(ListNode head){
        int count=0;
        ListNode cur=head;
        while(cur!=null){
            count+=1;
            cur=cur.next;
        }
        return count;
    }
}