class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(res,subset,nums,0);
        return res;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> subset,int[] nums,int i){
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(res,subset,nums,i+1);
        subset.remove(subset.size() - 1);
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        backtrack(res,subset,nums,i+1);
    }
}
