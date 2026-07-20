class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> permute = new ArrayList<>();
        backtrack(res, permute, nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(
        List<List<Integer>> res, List<Integer> permute, int[] nums, boolean[] picked) {
        if (permute.size() == nums.length) {
            res.add(new ArrayList<>(permute));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // you are checking if the current elem is picked
            // or 
            // if the current elem is not picked and i > 0 then we should only consider the current
            // elem if the previous elem is != curr elem and was not picked already
            if(picked[i] || (i > 0 && nums[i] == nums[i-1] && !picked[i-1])) continue;
            permute.add(nums[i]);
            picked[i] = true;
            backtrack(res, permute, nums, picked);
            permute.remove(permute.size() - 1);
            picked[i] = false;
        }
    }
}