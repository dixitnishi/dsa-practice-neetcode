class Solution {
    private int i = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int k = 0;
        while(i< s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                k = k*10 + (ch -'0');
            }else if(ch == '['){
                i++;
                String subRes = decodeString(s);
                while(k-- > 0) res.append(subRes);
                k = 0;
            }
            else if(ch == ']'){
                return res.toString();
            }
            else{
                res.append(ch);
            }
            i++;
        }
        return res.toString();
    }
}