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
    private HashMap<String,Integer> map=new HashMap<>();
    private List<TreeNode> result=new ArrayList<>();
    private String preorder(TreeNode root){
        if(root==null) return "null";
        String s=new String();
        s=(root.val)+","+preorder(root.left)+","+preorder(root.right);
        map.put(s,map.getOrDefault(s,0)+1);
        if(map.get(s)==2){
            result.add(root);
        }
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preorder(root);
        return result;
    }
}