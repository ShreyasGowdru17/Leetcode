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
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue=new ArrayDeque<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> answer=new ArrayList<>();
            int i=0;
            while(i<size){
                Node cur=queue.poll();
                answer.add(cur.val);
                i++;
                if(cur.children!=null){
                    for(Node children:cur.children){
                        queue.offer(children);
                    }
                }
            }
            result.add(new ArrayList<>(answer));
        }
        return result;
    }
}