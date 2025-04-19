/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur=head;
        while(cur!=null){
            Node node=new Node(cur.val);
            Node temp=cur.next;
            cur.next=node;
            node.next=temp;
            cur=cur.next.next;
        }

        cur=head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }

        cur=head;
        Node cloneHead=head.next;
        Node clone=cloneHead;
        while(clone.next!=null){
            cur.next=cur.next.next;
            clone.next=clone.next.next;
            cur=cur.next;
            clone=clone.next;
        }
        cur.next=null;
        return cloneHead;
    }
}