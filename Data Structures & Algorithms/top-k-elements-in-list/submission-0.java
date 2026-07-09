class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length+1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for(int i = 0;i<buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            buckets[entry.getValue()].add(entry.getKey());
        }

        int ans [] = new int[k];
        int idx = 0;
        int j = buckets.length-1;
        while(idx < k && j >= 0){
            for(int n : buckets[j]){
                ans[idx++] = n;
                if(idx == k) return ans;
            }
            j--;
        }
        return ans;
    }
}
