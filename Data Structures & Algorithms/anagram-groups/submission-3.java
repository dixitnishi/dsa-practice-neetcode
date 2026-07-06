class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
            for(char ch : s.toCharArray()){
                freq[ch - 'a']++;
            }
            String curr = Arrays.toString(freq);
            map.putIfAbsent(curr,new ArrayList<>());
            map.get(curr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
