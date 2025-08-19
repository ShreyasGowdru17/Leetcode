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
    private int leftHeight(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    private int rightHeight(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left=leftHeight(root);
        int right=rightHeight(root);
        if(left==right) return ((1<<left)-1);
        else return countNodes(root.left)+countNodes(root.right)+1;
    }
}