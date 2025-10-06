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
    private int val;
    private boolean flag=true;
    private void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);
        if(root.val!=val) flag=false;
        inorder(root.right); 
    }
    public boolean isUnivalTree(TreeNode root) {
        val=root.val;
        inorder(root);
        return flag;
    }
}