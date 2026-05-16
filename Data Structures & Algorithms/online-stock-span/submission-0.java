class StockSpanner {

    Stack<Integer> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        st.push(price);
        int count  = 0;
        List<Integer> temp = new ArrayList<>();
        while(!st.isEmpty() && st.peek() <= price){
            count++;
            temp.add(st.pop());
        }
        for(int i = temp.size() - 1 ; i>=0;i--){
            st.push(temp.get(i));
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */