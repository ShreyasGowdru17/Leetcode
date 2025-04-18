import java.util.Map;
import java.util.HashMap;
class Node{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key,int value){
        this.key=key;
        this.value=value;
        this.next=null;
        this.prev=null;
    }
}
class LRUCache {
    private int capacity;
    private Map<Integer,Node> cacheMap;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cacheMap=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        Node node=cacheMap.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            Node oldNode =cacheMap.get(key);
            remove(oldNode);
        }
        Node node=new Node(key,value);
        add(node);
        cacheMap.put(key,node);

        if(cacheMap.size()>capacity){
            Node oldNode=tail.prev;
            remove(oldNode);
            cacheMap.remove(oldNode.key);
        }
    }

    private void add(Node node){
        Node nextNode=head.next;
        head.next=node;
        nextNode.prev=node;
        node.prev=head;
        node.next=nextNode;
    }
    private void remove(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */