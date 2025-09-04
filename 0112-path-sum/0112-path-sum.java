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
    private int count;
    public boolean hasPathSum(TreeNode root,int targetSum,int count){
        if(root==null) return false;
        count+=root.val;
        if(root.left==null && root.right==null && count==targetSum){
            return true;
        }
        boolean left=hasPathSum(root.left,targetSum,count);
        boolean right=hasPathSum(root.right,targetSum,count);
        return (left==true || right==true)?true:false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root,targetSum,0);
    }
}