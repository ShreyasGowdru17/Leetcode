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
        if(head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while(cur != null){
            ListNode nextNode = cur.next; 
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        return prev; 
    }
    public boolean isPalindrome(ListNode head) {

      if(head == null || head.next == null){
         return true;
      }   

      ListNode slow = head;
      ListNode fast = head;

      while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }

      if(fast != null){
        slow = slow.next;
      }

      ListNode newHead = reverse(slow);
      ListNode first = head;
      ListNode second = newHead;

      while(second != null){

            if(first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
      }

      return true;
    }
}