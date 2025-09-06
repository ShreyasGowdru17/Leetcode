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
    StringBuilder sb=new StringBuilder();
    String smallest=null;
    StringBuilder smallestPath;
    public void smallestFromLeaf(TreeNode root,int count){
        if(root==null) return;
        count+=root.val;
        sb.append((char)('a'+root.val));
        int size=sb.length();
        if(root.left==null && root.right==null){
            String path=sb.reverse().toString();
            sb.reverse();

            if(smallest==null || path.compareTo(smallest)<0){
                smallest=path;
                smallestPath=new StringBuilder(sb);
            }
        }
        smallestFromLeaf(root.left,count);
        smallestFromLeaf(root.right,count);
        sb.setLength(size-1);
    }
    public String smallestFromLeaf(TreeNode root) {
        smallestFromLeaf(root,0);
        return smallest;
    }
}