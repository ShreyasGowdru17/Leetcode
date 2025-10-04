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
    private int count=0;
    private int postOrder(TreeNode root){
        if(root==null) return 0;
        int value=root.val;
        int left=postOrder(root.left);
        int right=postOrder(root.right);
        count+=Math.abs(left-right);
        return left+right+value;

    }
    public int findTilt(TreeNode root) {
        postOrder(root);
        return count;
    }
}