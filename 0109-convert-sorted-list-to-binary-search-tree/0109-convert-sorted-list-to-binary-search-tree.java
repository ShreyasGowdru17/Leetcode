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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode inorder(ListNode head,ListNode tail){
        if(head==null || head==tail){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=tail && fast.next!=tail){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=inorder(head,slow);
        root.right=inorder(slow.next,tail);
        return root; 
    }
    public TreeNode sortedListToBST(ListNode head) {
        return inorder(head,null);
    }
}