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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        int maxSum=Integer.MIN_VALUE;
        int level=0;
        int maxLevel=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            int curTotal=0;
            while(size>0){
                TreeNode cur=queue.poll();
                curTotal+=cur.val;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
                size--;
            }
            level++;
            if(curTotal>maxSum){
                maxSum=curTotal;
                maxLevel=level;
            }
        }
        return maxLevel;
    }
}