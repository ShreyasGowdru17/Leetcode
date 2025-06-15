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
    public ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergeList(ListNode head1,ListNode head2){
        ListNode temp1=head1;
        ListNode temp2=head2;
        ListNode dummy=new ListNode(-1);
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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=findMiddle(head);
        ListNode leftHead=head;
        ListNode rightHead=mid.next;
        mid.next=null;
        ListNode left=sortList(leftHead);
        ListNode right=sortList(rightHead);
        return mergeList(left,right);
    }
}