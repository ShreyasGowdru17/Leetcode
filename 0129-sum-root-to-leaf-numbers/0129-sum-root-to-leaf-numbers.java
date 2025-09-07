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
    public void sumNumbers(TreeNode root,StringBuilder sb){
        if(root==null) return;

        sb.append(root.val);
        int n=sb.length();
        if(root.left==null && root.right==null){
            String s=sb.toString();
            total+=Integer.parseInt(s);
        }
        sumNumbers(root.left,sb);
        sumNumbers(root.right,sb);
        sb.setLength(n-1);
    }
    public int sumNumbers(TreeNode root) {
        sumNumbers(root,new StringBuilder());
        return total;
    }
}