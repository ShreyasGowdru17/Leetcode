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
class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        TreeNode cur=root;
        stack=new Stack<>();
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
    }
    
    public int next() {
        TreeNode cur=stack.pop();
        int result=cur.val;
        if(cur.right!=null){
            cur=cur.right;
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
        }
       
        return result;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */