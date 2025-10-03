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
    private List<Integer> result=new ArrayList<>();
    private void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorder(root);
        List<List<Integer>> answer=new ArrayList<>();
        for(int query:queries){
            int smaller=-1;
            int larger=-1;
            int index=Collections.binarySearch(result,query);
            if(index>=0){
                smaller=result.get(index);
                larger=result.get(index);
            }else{
                int insertionPoint=-(index+1);
                if(insertionPoint==0){
                    larger=result.get(0);
                }else if(insertionPoint==result.size()){
                    smaller=result.get(result.size()-1);
                }else{
                    larger=result.get(insertionPoint);
                    smaller=result.get(insertionPoint-1);
                }
            }
            answer.add(Arrays.asList(smaller,larger));
        }
        return answer;
    }
}