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
                    num = 0; // setting it 0 as we dont need the curr elem in answer
                else{
                    num = 0;   // setting it zero as the diff is cancelling out the 
                    st.pop();  // num on the top so we pop as well
                }        
            }
            if(num != 0)
                st.push(num); // check of the num is not manually set to 0 given 
                // following constraint asteroids[i] != 0
        }
        return st.stream().mapToInt(i -> i).toArray();
    }
}