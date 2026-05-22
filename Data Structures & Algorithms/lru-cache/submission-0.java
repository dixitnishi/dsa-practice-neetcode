class Node{
    public int key;
    public int value;
    public Node next;
    public Node prev;

    public Node(){
        this.key = -1;
        this.value = -1;
    }
    public Node(int key,int val){
        this.key = key;
        this.value = val;
    }
}

class LRUCache {

    Map<Integer,Node> cache;
    private Node head;
    private Node tail;
    private int cap;

    private void deleteNode(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    private void insertAfterHead(Node node){
        Node nextNode = head.next;
        node.next = nextNode;
        nextNode.prev = node;
        head.next = node;
        node.prev = head;
    }

    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node  = cache.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node existingNode = cache.get(key);
            existingNode.value = value;
            deleteNode(existingNode);
            insertAfterHead(existingNode);
            cache.put(key,existingNode);
            return;
        }
        if(cache.size() == cap){
            Node node = tail.prev;
            deleteNode(node);
            cache.remove(node.key);
        }
        Node newNode = new Node(key,value);
        insertAfterHead(newNode);
        cache.put(key,newNode);
    }
}
