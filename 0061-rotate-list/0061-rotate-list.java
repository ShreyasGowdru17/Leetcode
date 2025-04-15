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
    public ListNode rotateRight(ListNode head, int k) {
        int count=countNodes(head);
        if (count==0 || count==1 || k==0){
            return head;
        }
        int rotate=k%(count);
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=head;
        int pos=1;
        int remaining=count-rotate;
        cur=head;
        while(pos<remaining){
            cur=cur.next;
            pos+=1;
        }
        ListNode start=cur.next;
        cur.next=null;
        return start;
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