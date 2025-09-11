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
    private int minimum;
    private long secondMinimum=Long.MAX_VALUE;
    private void preorder(TreeNode root){
        if(root==null) return;

        if(root.val<minimum){
            secondMinimum=minimum;
            minimum=root.val;
        }
        if(root.val>minimum && root.val<secondMinimum){
            secondMinimum=root.val;
        }
        preorder(root.left);
        preorder(root.right);
    }
    public int findSecondMinimumValue(TreeNode root) {
        minimum=root.val;
        preorder(root);
        return secondMinimum<Long.MAX_VALUE?(int)secondMinimum:-1;
    }
}