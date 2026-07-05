class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                return new int[]{map.get(rem),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
