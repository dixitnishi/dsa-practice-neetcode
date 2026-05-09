class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int num : asteroids){
            while(!st.isEmpty() && num < 0 && st.peek() > 0){
                // current num is -ve, top of stack is +ve and st is not empty
                int diff = num + st.peek();
                if(diff < 0) // curr num abs value is > top elem in stack
                    st.pop();
                else if(diff > 0) // curr num abs value is < top elem in stack
                    num = 0;
                else{
                    num = 0;
                    st.pop();
                }        
            }
            if(num != 0)
                st.push(num);
        }
        return st.stream().mapToInt(i -> i).toArray();
    }
}