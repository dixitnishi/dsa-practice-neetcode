class Solution {
    public String longestCommonPrefix(String[] strs) {
        // for(int i = 0;i<strs[0].length();i++){
        //     for(String str : strs){
        //         if(i == str.length() || str.charAt(i) != strs[0].charAt(i)){
        //             return str.substring(0,i);
        //         }
        //     }
        // }
        // return strs[0];

        String prefix = strs[0];
        for(int i = 1;i<strs.length;i++){
            int j = 0;
            String curr = strs[i];
            int minLen = Math.min(curr.length(),prefix.length());
            while(j < minLen){
                if(curr.charAt(j) != prefix.charAt(j)){
                    break;
                }
                j++;
            }
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
}