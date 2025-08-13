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
    int level;
    TreeNode node;
    public Tuple(int level,TreeNode node){
        this.level=level;
        this.node=node;
    }
}
class Solution {
    private void preorder(TreeNode node,int level,TreeMap<Integer,Integer> map){
        if(node==null) return;
        map.put(level,node.val);
        preorder(node.left,level+1,map);
        preorder(node.right,level+1,map);
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        /*Deque<Tuple> queue=new ArrayDeque<>();
        queue.offer(new Tuple(0,root));
        while(!queue.isEmpty()){
            Tuple tuple=queue.poll();
            TreeNode cur=tuple.node;
            int level=tuple.level;
            map.put(level,cur.val);
            if(cur.left!=null) queue.offer(new Tuple(level+1,cur.left));
            if(cur.right!=null) queue.offer(new Tuple(level+1,cur.right));
        }*/
        preorder(root,0,map);
        List<Integer> result=new ArrayList<>();
        for(Integer value:map.values()){
            result.add(value);
        }
        return result;
    }
}