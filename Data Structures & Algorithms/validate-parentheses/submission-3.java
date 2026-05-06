class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        char c = s.charAt(0);
        if(c == ']' || c == ')' || c == '}') return false;
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.isEmpty()) return false;
                char top = st.peek();
                if((ch == '}' && top != '{') || (ch == ']' && top != '[') || (ch == ')' && top != '(')) return false;
                else st.pop();
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}
