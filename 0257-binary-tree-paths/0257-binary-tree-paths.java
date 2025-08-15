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
    private void inorder(TreeNode root,List<String> result,StringBuilder answer){
        if(root==null) return;
        int length=answer.length();
        answer.append(root.val);
        if(root.left==null && root.right==null){
            result.add(answer.toString());
        }
        else{
            answer.append("->");
            inorder(root.left,result,answer);
            inorder(root.right,result,answer);
        }
        answer.setLength(length);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        inorder(root,result,new StringBuilder());
        return result;
    }
}