/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private List<Integer> result=new ArrayList<>();
    private void traverse(Node root){
        if(root==null) return;

        result.add(root.val);
        for(int i=0;i<root.children.size();i++){
            traverse(root.children.get(i));
        }
    }
    public List<Integer> preorder(Node root) {
        traverse(root);
        return result;
    }

}