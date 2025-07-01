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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prevNode=dummy;
        ListNode curNode=head;
        while(curNode!=null){
            
            if(curNode.next!=null && curNode.val==curNode.next.val){
                int duplicate=curNode.val;
                while(curNode!=null && duplicate==curNode.val){
                    curNode=curNode.next;
                }
                prevNode.next=curNode;
            }
            else{
                prevNode=curNode;
                curNode=curNode.next;
            }
            
        }
        return dummy.next;
    }
}