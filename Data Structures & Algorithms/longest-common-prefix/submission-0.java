class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i = 1;i<strs.length;i++){
            String curr = strs[i];
            int j = 0;
            int minLen = Math.min(curr.length(),prefix.length());
            while(j < minLen){
                if(prefix.charAt(j) != curr.charAt(j)){
                    break;
                }
                j++;
            }
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
}