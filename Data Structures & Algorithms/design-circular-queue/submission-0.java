class Node{
    public int data;
    public Node prev;
    public Node next;

    public Node(){
        this.data = -1;
    }

    public Node(int data){
        this.data = data;
    }
}
class MyCircularQueue {
    
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    private void insertBeforeTail(Node node){
        Node tailPrev = tail.prev;
        node.next = tail;
        tail.prev = node;
        node.prev = tailPrev;
        tailPrev.next = node;
    }

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        head.prev = tail;
        tail.next = head;
    }
    
    public boolean enQueue(int value) {
        if(size == capacity){
            return false;
        }
        Node newNode = new Node(value);
        insertBeforeTail(newNode);
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(head.next == tail){
            return false;
        }
       Node headNextNext = head.next.next;
        headNextNext.prev = head;
        head.next = headNextNext;
        size--;
        return true;
    }
    
    public int Front() {
        return head.next.data;
    }
    
    public int Rear() {
        if(tail.prev == null) return -1;
        return tail.prev.data;
    }
    
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
        
    }
    
    public boolean isFull() {
        if(size == capacity) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */