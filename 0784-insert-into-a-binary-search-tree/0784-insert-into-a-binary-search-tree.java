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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode prev=null;
        TreeNode cur=root;
        if(cur==null) return cur=new TreeNode(val);
        while(cur!=null){
            prev=cur;
            if(val>cur.val) cur=cur.right;
            else cur=cur.left;
        }
        if(cur==null && prev.val>val){
            cur=new TreeNode(val);
            prev.left=cur;
        }else{
            cur=new TreeNode(val);
            prev.right=cur;
        }
        return root;
    }
}