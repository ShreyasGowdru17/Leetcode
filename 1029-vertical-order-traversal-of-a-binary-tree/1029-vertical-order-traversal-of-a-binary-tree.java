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
    int level;
    int vertical;
    public Tuple(TreeNode node,int level,int vertical){
        this.node=node;
        this.level=level;
        this.vertical=vertical;
    }
}
class Solution {
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Deque<Tuple> queue=new ArrayDeque<>();
        queue.offer(new Tuple(root,0,0));
        while(!queue.isEmpty()){
            Tuple tuple=queue.poll();
            TreeNode current=tuple.node;
            int level=tuple.level;
            int vertical=tuple.vertical;
            if(!map.containsKey(vertical)){
                map.put(vertical,new TreeMap<>());
            }
            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level,new PriorityQueue<>());
            }
            map.get(vertical).get(level).offer(current.val);

            if(current.left!=null){
                queue.offer(new Tuple(current.left,level+1,vertical-1));
            }
            if(current.right!=null){
                queue.offer(new Tuple(current.right,level+1,vertical+1));
            }
        } 
        List<List<Integer>> result=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> row:map.values()){
            List<Integer> answer=new ArrayList<>();
            for(PriorityQueue<Integer> pq:row.values()){
                while(!pq.isEmpty()){
                    answer.add(pq.poll());
                }
            }
            result.add(new ArrayList<>(answer));
        }
        return result;
    }
}