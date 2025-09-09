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
    public int pathSum(TreeNode root,int targetSum,Long total,HashMap<Long,Integer> map){
        if(root==null) return 0;

        total+=root.val;
        int count=map.getOrDefault(total-targetSum,0);
        map.put(total,map.getOrDefault(total,0)+1);
        count+=pathSum(root.left,targetSum,total,map)+pathSum(root.right,targetSum,total,map);
        map.put(total,map.get(total)-1);
        return count;

    }
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map=new HashMap<>();
        map.put(0L,1);
        return pathSum(root,targetSum,0L,map);

    }
}