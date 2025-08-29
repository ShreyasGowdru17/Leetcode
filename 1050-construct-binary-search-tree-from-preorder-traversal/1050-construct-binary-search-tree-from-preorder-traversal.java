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
    int index=0;
    private TreeNode bst(int[] preorder,int bound){
        if(index==preorder.length) return null;
        if(preorder[index]>bound) return null;

        TreeNode cur=new TreeNode(preorder[index++]);
        cur.left=bst(preorder,cur.val); 
        cur.right=bst(preorder,bound);
        return cur;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder,Integer.MAX_VALUE);
    }
}