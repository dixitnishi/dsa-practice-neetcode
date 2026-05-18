class FreqStack {
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> stacks;
    int maxi;

    public FreqStack() {
        freq = new HashMap<>();
        stacks = new HashMap<>();
        maxi = 0;
    }
    
    public void push(int val) {
        int valCnt = freq.getOrDefault(val,0) + 1;
        freq.put(val,valCnt);
        if(valCnt > maxi){
            maxi = valCnt;
            stacks.putIfAbsent(valCnt,new Stack<>());
        }
        stacks.get(valCnt).push(val);
        
    }
    
    public int pop() {
        int res = stacks.get(maxi).pop();
        freq.put(res,freq.get(res) - 1);
        if(stacks.get(maxi).isEmpty()){
            maxi--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */