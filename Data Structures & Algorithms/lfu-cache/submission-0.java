class Node{
    int key, val, freq;
    Node prev,next;
    Node(int key,int val){
        this.key = key;
        this.val = val;
        this.freq = 1;
    }

}


class DoublyLinkedList{
    private Node head,tail;
    private int size;

    DoublyLinkedList(){
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

    public int length(){
        return this.size;
    }

    public void pushHead(Node node){
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }

    public void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }

    public Node deleteLru(){
        Node tailPrev = tail.prev;
        deleteNode(tailPrev);
        return tailPrev;
    }

}
class LFUCache {

    private int capacity;
    private int lfuCnt;
    private Map<Integer,Node> nodeMap;
    private Map<Integer,DoublyLinkedList> listMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lfuCnt = 0;
        this.nodeMap = new HashMap<>();
        this.listMap = new HashMap<>();
    }

    private void counter(Node node){
        int count  = node.freq;
        listMap.get(count).deleteNode(node);

        if(count == lfuCnt && listMap.get(count).length() == 0){
            lfuCnt++;
        }
        node.freq++;
        listMap.putIfAbsent(node.freq,new DoublyLinkedList());
        listMap.get(node.freq).pushHead(node);
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        counter(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }

        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.val = value;
            counter(node);
            return;
        }
        
        if(nodeMap.size() == capacity){
            Node toRemove = listMap.get(lfuCnt).deleteLru();
            nodeMap.remove(toRemove.key);
        }

        Node newNode = new Node(key,value);
        nodeMap.put(key,newNode);
        listMap.putIfAbsent(1,new DoublyLinkedList());
        listMap.get(1).pushHead(newNode);
        lfuCnt = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */