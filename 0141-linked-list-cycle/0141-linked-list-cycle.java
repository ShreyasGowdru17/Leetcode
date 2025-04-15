/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        ListNode cur=head;
        while(cur!=null){
            if(set.contains(cur.next)){
                return true;
            }
            set.add(cur.next);
            cur=cur.next;
        }
        return false;
    }
}