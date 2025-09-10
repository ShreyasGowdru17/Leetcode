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
    private int minimum=Integer.MAX_VALUE;
    private Integer prev=null;
    private void inorder(TreeNode root){
        if(root==null) return;
    
        inorder(root.left);
        if(prev!=null){
            minimum=Math.min(minimum,root.val-prev);
        }
        prev=root.val;
        inorder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minimum;
    }
}