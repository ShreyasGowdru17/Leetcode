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
    public int maxDepth(Node root) {
        if(root==null) return 0;
        List<Node> children=root.children;
        int size=children.size();
        int max=0;
        for(int i=0;i<size;i++){
            int total=maxDepth(children.get(i));
            max=Math.max(max,total);
        }
        return max+1;
    }
}