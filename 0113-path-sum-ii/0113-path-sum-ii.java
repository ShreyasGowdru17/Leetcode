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
    List<List<Integer>> result=new ArrayList<>();
    public void pathSum(TreeNode root,int targetSum,int total,List<Integer> answer){
        if(root==null) return;

        total+=root.val;
        answer.add(root.val);
        if(root.left==null && root.right==null && total==targetSum){
            result.add(new ArrayList<>(answer));
        }
        pathSum(root.left,targetSum,total,answer);
        pathSum(root.right,targetSum,total,answer);
        answer.remove(answer.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root,targetSum,0,new ArrayList<>());
        return result;
    }
}