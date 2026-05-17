class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String curr = "";
        path+= "/";
        for(int i = 0;i<path.length();i++){
            char ch = path.charAt(i);
            if(ch == '/'){
                if(curr.equals("..")){
                    if(!st.isEmpty())
                        st.pop();
                }
                else if(!curr.equals("") && !curr.equals(".")){
                    st.push(curr);
                }
                curr = "";
            }
            else{
                curr+=ch;
            }
        }

        
        return "/" + String.join("/", st);
        




        // path = path.replaceAll("/{2,}", "/");
        // if(path.charAt(0) == '/'){
        //     path = path.substring(1,path.length());
        // }
        // String temp[] = path.split("/");
        // Stack<String> st = new Stack<>();
        // for(String curr : temp){
        //     if(curr.equals("")) continue;
        //     else if(curr.equals("..") && !st.isEmpty()){
        //         st.pop();
        //         continue;
        //     }else if(curr.equals(".")){
        //         continue;
        //     }
        //     else{
        //         st.push("/"+curr);
        //     }
        // }
        // List<String> list = new ArrayList<>();
        // while(!st.isEmpty()){
        //     list.add(st.pop());
        // }
        // StringBuilder sb = new StringBuilder();
        
        // for(int i = list.size()-1 ;i >= 0 ;i--){
        //     sb.append(list.get(i));
        // }
        // return sb.toString();
    }
}