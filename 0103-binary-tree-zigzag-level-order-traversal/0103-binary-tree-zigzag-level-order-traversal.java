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
                if(level%2==0){
                    TreeNode cur=queue.removeLast();
                    answer.add(cur.val);
                    if(cur.left!=null) queue.addFirst(cur.left);
                    if(cur.right!=null) queue.addFirst(cur.right); 
                }else{
                    TreeNode cur=queue.removeFirst();
                    answer.add(cur.val);
                    if(cur.right!=null) queue.addLast(cur.right);
                    if(cur.left!=null) queue.addLast(cur.left);
                }
                count--;
            }
            result.add(new ArrayList<>(answer));
            level++;
        }
        return result;
    }
}