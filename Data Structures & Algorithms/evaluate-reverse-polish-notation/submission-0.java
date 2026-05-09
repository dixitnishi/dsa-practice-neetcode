class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        for(String num : tokens){
            if(num.equals("+")){
                // what if the stack is empty 
                int elem1  = st.pop();
                int elem2  = st.pop();
                result = (elem1 + elem2);
                st.push(result);
            }
            else if(num.equals("*")){
                int elem1  = st.pop();
                int elem2  = st.pop();
                result = (elem1 * elem2);
                st.push(result);
            }
            else if(num.equals("/")){
                int elem1  = st.pop();
                int elem2  = st.pop();
                result = (elem2 / elem1);
                st.push(result);
            }
            else if(num.equals("-")){
                int elem1  = st.pop();
                int elem2  = st.pop();
                result = (elem2 - elem1);
                st.push(result);
            }else{
                st.push(Integer.valueOf(num));
                result = Integer.valueOf(num);
            }
        }
        return result;
    }
}
