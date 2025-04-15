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
        ListNode slow=head;
        ListNode fast=head;
        while( (fast!=null) && (fast.next!=null)){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}

// Set<ListNode> set=new HashSet<>();
// ListNode cur=head;
// while(cur!=null){
//     if(set.contains(cur.next)){
//         return true;
//     }
//     set.add(cur.next);
//     cur=cur.next;
// }
// return false;