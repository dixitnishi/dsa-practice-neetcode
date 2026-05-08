class MyQueue {

    // first in first out data structure
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    public MyQueue() {
        st1  = new Stack<>();
        st2  = new Stack<>();
    }
    
    public void push(int x) {
        st2.push(x);

    }
    
    public int pop() {
        for(int i = st2.size() -1 ;i > 0 ;i--){
            st1.push(st2.pop());
        }
        int ans = st2.pop();
        while(!st1.isEmpty()) st2.push(st1.pop());
        return ans;
    }
    
    public int peek() {
        for(int i = st2.size() -1 ;i > 0 ;i--){
            st1.push(st2.pop());
        }
        int ans = st2.peek();
        while(!st1.isEmpty()) st2.push(st1.pop());
        return ans;
    }
    
    public boolean empty() {
        return st2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */