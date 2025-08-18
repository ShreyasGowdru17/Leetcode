/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        Map<TreeNode,TreeNode> map=new HashMap<>();
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.left!=null) {
                map.put(cur.left,cur);
                queue.offer(cur.left);
            }
            if(cur.right!=null) {
                map.put(cur.right,cur);
                queue.offer(cur.right);
            };
        }
        Set<TreeNode> visited=new HashSet<>();
        queue=new ArrayDeque<>();
        queue.add(target);
        visited.add(target);
        int level=0;
        while(level<k){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left!=null && !visited.contains(cur.left)){
                    queue.add(cur.left);
                    visited.add(cur.left);
                }
                if(cur.right!=null && !visited.contains(cur.right)){
                    queue.add(cur.right);
                    visited.add(cur.right);
                }
                if(map.containsKey(cur) && !visited.contains(map.get(cur))){
                    queue.add(map.get(cur));
                    visited.add(map.get(cur));
                }
            }
            level++;
        }
        List<Integer> result=new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }
        return result;
    }
}