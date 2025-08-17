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
 class Tuple{
    TreeNode node;
    int num;
    public Tuple(TreeNode node,int num){
        this.node=node;
        this.num=num;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Tuple> queue=new ArrayDeque<>();
        queue.offer(new Tuple(root,0));
        int maximum=0;
        while(!queue.isEmpty()){
            int left=0;
            int right=0;
            int size=queue.size();
            int min=queue.peek().num;
            for(int i=0;i<size;i++){
                Tuple tuple=queue.poll();
                TreeNode cur=tuple.node;
                int num=tuple.num-min;
                if(i==0) left=num;
                if(i==size-1) right=num;
                if(cur.left!=null) queue.offer(new Tuple(cur.left,num*2+1));
                if(cur.right!=null) queue.offer(new Tuple(cur.right,num*2+2));
            }
            maximum=Math.max(maximum,right-left+1);
        }
        return maximum;
    }
}