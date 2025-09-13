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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        List<Long> result=new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            long total=0L;
            while(size>0){
                TreeNode cur=queue.poll();
                total+=cur.val;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
                size--;
            }
            result.add(total);
        }
        Collections.sort(result,Collections.reverseOrder());
        System.out.println(result);
        return k<=result.size()?result.get(k-1):-1;

    }
}