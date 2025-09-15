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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean flag1=false;
            boolean flag2=false;
            while(size>0){
                TreeNode cur=queue.poll();
                if(cur.left!=null && cur.right!=null ){
                    if((cur.left.val==x && cur.right.val==y) || (cur.left.val==y && cur.right.val==x))return false;
                }
                if(cur.val==x) flag1=true;
                if(cur.val==y) flag2=true;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
                size--;
            }
            if(flag1 && flag2) return true;
            if(flag1 || flag2) return false;
        }
        return false;
    }
}