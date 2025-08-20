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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1,map);
        return root;
    }
    private TreeNode buildTree(int[] preorder,int[] inorder,int preStart,int preEnd,int inStart,int inEnd,HashMap<Integer,Integer> map){
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root=new TreeNode(preorder[preStart]);
        int inRoot=map.get(preorder[preStart]);
        int numsLeft=inRoot-inStart;
        root.left=buildTree(preorder,inorder,preStart+1,preStart+numsLeft ,inStart,inRoot-1,map);
        root.right=buildTree(preorder,inorder,preStart+numsLeft+1,preEnd,inRoot+1,inEnd,map);
        return root;
    }
}