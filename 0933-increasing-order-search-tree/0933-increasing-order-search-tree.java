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
    private TreeNode cur;
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        root.left=null;
        cur.right=root;
        cur=root;
        inorder(root.right);

    }
    public TreeNode increasingBST(TreeNode root) {
       TreeNode dummy=new TreeNode(-1);
       cur=dummy;
       inorder(root);
       return dummy.right;
    }
}