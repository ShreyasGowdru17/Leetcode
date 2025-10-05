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
    private TreeNode prev=null;
    private int total=0;
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.right);
        root.val+=total;
        total=root.val;
        inorder(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        return root;
    }
}