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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        root.val=0;
        queue.offer(root);
        while(!queue.isEmpty()){

            Map<TreeNode,Integer> childMap=new HashMap<>();
            int size=queue.size();
            List<TreeNode> nodes=new ArrayList<>();
            int levelSum=0;
            while(size>0){
                int childSum=0;
                TreeNode cur=queue.poll();
                nodes.add(cur);
                if(cur.left!=null) childSum+=cur.left.val;
                if(cur.right!=null) childSum+=cur.right.val;
                levelSum+=childSum;
                childMap.put(cur,childSum);
                size--;
            }

            for(TreeNode node:nodes){
                if(node.left!=null){
                    node.left.val=levelSum-childMap.get(node);
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    node.right.val=levelSum-childMap.get(node);
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}