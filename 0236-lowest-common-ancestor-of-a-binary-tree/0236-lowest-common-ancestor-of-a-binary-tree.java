/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode preorder(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return null;

        if(root==p || root==q){
            return root;
        }
        TreeNode left=preorder(root.left,p,q);
        TreeNode right=preorder(root.right,p,q);
        if(left!=null && right!=null) return root;
        return (left!=null ?left:right);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return preorder(root,p,q);
    }
}