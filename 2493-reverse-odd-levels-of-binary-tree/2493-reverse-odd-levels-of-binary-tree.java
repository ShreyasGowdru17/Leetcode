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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        int level=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            level++;
            List<TreeNode> list=new ArrayList<>();
            while(size>0){
                TreeNode cur=queue.poll();
                list.add(cur);
                if(cur.left!=null)queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
                size--;
            }
            if(level%2==1){
                int n=list.size();
                int i=0;
                int j=n-1;
                while(i<=j){
                    TreeNode node1=list.get(i);
                    TreeNode node2=list.get(j);
                    int node1Val=node1.val;
                    node1.val=node2.val;
                    node2.val=node1Val;
                    i++;
                    j--;
                }
            }
        }
        return root;
    }
}