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
    private int rightSum=0;
    private void inorderTraversal(TreeNode root){
        if(root==null) return;
        inorderTraversal(root.right);
        root.val+=rightSum;
        rightSum=root.val;
        inorderTraversal(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
        inorderTraversal(root);
        return root;
    }
}