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
    public int minimumOperations(TreeNode root) {
        if(root==null) return 0;
        int count=0;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int length=size;
            int[] array=new int[size];
            int j=0;
            while(length>0){
                TreeNode cur=queue.poll();
                array[j++]=cur.val;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
                length--;
            }
            
            int[][] pairs=new int[size][2];
            for(int i=0;i<size;i++){
                pairs[i][0]=array[i];
                pairs[i][1]=i;
            }

            Arrays.sort(pairs,Comparator.comparingInt(a->a[0]));

            for(int i=0;i<size;i++){
                if(pairs[i][1]==i) continue;
                else{
                    count++;
                    int correctIndex=pairs[i][1];
                    int[] temp=pairs[i];
                    pairs[i]=pairs[correctIndex];
                    pairs[correctIndex]=temp;
                    i--;
                }
            }
        }
        return count;
    }
}