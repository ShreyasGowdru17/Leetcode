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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> queue=new ArrayDeque<>();
        int level=0;
        queue.add(root);
        while(!queue.isEmpty()){
            int count=queue.size();
            List<Integer> answer=new ArrayList<>();
            while(count>0){
                TreeNode cur=queue.remove();
                answer.add(cur.val);
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right); 
                count--;
            }
            if(level%2==0){
                result.add(new ArrayList<>(answer));
            }
            else{
                Collections.reverse(answer);
                result.add(new ArrayList<>(answer));
            }
            level++;
        }
        return result;
    }
}