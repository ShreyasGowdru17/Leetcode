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
    private StringBuilder sb=new StringBuilder();
    public void preorder(TreeNode root){
        if(root==null){
            return;
        }

        sb.append(root.val);
        if(root.left!=null){
            sb.append("(");
            preorder(root.left);
        }else if(root.left==null && root.right!=null){
            sb.append("()");
        }
        if(root.right!=null){
            sb.append("(");
            preorder(root.right);
        }
        sb.append(")");
    }
    public String tree2str(TreeNode root) {
        preorder(root);
        String s=sb.toString();
        int n=s.length();
        return s.substring(0,n-1);
    }
}