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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prevNode=dummy;
        ListNode curNode;
        ListNode nextNode;
        while(prevNode!=null && prevNode.next!=null && prevNode.next.next!=null){
            curNode=prevNode.next;
            nextNode=curNode.next;
            ListNode temp=nextNode.next;
            prevNode.next=nextNode;
            nextNode.next=curNode;
            curNode.next=temp;
            prevNode=prevNode.next.next;
        }
        return dummy.next;
    }
}