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
    public int countNodes(ListNode head){
        int count=0;
        ListNode cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int count=countNodes(head);
        if(count==0 || count==1 || k==0){
            return head;
        }
        int rotate=k%count;
        int remaining=count-rotate;
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=head;
        ListNode temp=head;
        count=1;
        while(count<remaining){
            count++;
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
        return head;
    }
    
}