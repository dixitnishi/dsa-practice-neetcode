class Node{
    public int data;
    public int key;
    public Node next;
    public Node prev;

    public Node(int key,int data){
        this.key = key;
        this.data = data;
    }
}

class LRUCache {

    private Node head;
    private Node tail;
    private Map<Integer,Node> cacheMap;
    int cap;

    private void insertAfterHead(Node node){
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }


    public LRUCache(int capacity) {
        cap = capacity;
        cacheMap = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)) return -1;
        Node node = cacheMap.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.data;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            node.data = value;
            deleteNode(node);
            insertAfterHead(node);
            cacheMap.put(key,node);
            return;
        }
        if(cacheMap.size() == cap){
            Node tailPrev = tail.prev;
            deleteNode(tailPrev);
            cacheMap.remove(tailPrev.key);
        }
        Node newNode = new Node(key,value);
        insertAfterHead(newNode);
        cacheMap.put(key,newNode);
    }
}
