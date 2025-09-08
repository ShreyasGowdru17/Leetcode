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
    int total=0;
    public int longestUniValue(TreeNode root){
        if(root==null) return 0;

        
        int left=longestUniValue(root.left);
        int right=longestUniValue(root.right);
        int leftPath=0;
        int rightPath=0;
        if(root.left!=null && root.left.val==root.val){
            leftPath=left+1;
        }
        if(root.right!=null && root.right.val==root.val){
            rightPath=right+1;
        }
        total=Math.max(total,leftPath+rightPath);
        return Math.max(leftPath,rightPath);

    }
    public int longestUnivaluePath(TreeNode root) {
        longestUniValue(root);
        return total;
    }
}