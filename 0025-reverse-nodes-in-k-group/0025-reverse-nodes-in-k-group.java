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
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
    public ListNode findKNode(ListNode head,int k){
        k--;
        ListNode temp=head;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevNode=null;
        while(temp!=null){

            ListNode kNode=findKNode(temp,k);
            if(kNode==null){
                if(prevNode!=null){
                    prevNode.next=temp;
                }
                break;
            }
            ListNode nextNode=kNode.next;
            kNode.next=null;
            ListNode newHead=reverse(temp);
            if(temp==head){
                head=newHead;
            }
            else{
                prevNode.next=newHead;
               
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
}