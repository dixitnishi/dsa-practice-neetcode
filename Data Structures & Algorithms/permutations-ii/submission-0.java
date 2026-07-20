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
            if(picked[i] || (i > 0 && nums[i] == nums[i-1] && !picked[i-1])) continue;
            permute.add(nums[i]);
            picked[i] = true;
            backtrack(res, permute, nums, picked);
            permute.remove(permute.size() - 1);
            picked[i] = false;
        }
    }
}