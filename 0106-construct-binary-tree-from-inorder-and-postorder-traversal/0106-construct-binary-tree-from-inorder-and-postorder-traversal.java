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
    private TreeNode buildTree(int[] inorder,int[] postorder,int inStart,int inEnd,int postStart,int postEnd,HashMap<Integer,Integer> map){
        if(inStart>inEnd || postStart>postEnd) return null;
        TreeNode root=new TreeNode(postorder[postEnd]);
        int inRoot=map.get(postorder[postEnd]);
        int numsLeft=inRoot-inStart;
        root.left=buildTree(inorder,postorder,inStart,inRoot-1,postStart,postStart+numsLeft-1,map);
        root.right=buildTree(inorder,postorder,inRoot+1,inEnd,postStart+numsLeft,postEnd-1,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1,map);
        return root;
    }
}