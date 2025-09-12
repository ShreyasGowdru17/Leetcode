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
    private int maxMode=0;
    private int maxNode=0;
    private Integer prev=null;
    private int count=0;
    private List<Integer> result=new ArrayList<>();
    private void inorder(TreeNode root){
        if(root==null) return ;

        inorder(root.left);
        if(prev!=null && prev==root.val){
            count++;
            maxNode=prev;
        }else{
            count=1;
        }
        if(count==maxMode){
            result.add(root.val);
        }else if(count>maxMode){
                maxMode=count;
                result.clear();
                result.add(root.val);
        }
        prev=root.val;
        inorder(root.right);
    }
    public int[] findMode(TreeNode root) {
        inorder(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}