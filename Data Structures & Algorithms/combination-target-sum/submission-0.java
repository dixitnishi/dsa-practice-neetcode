class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        helper(nums,target,ans,combination,0);
        return ans;
    }

    public void helper(int[] nums,int target,List<List<Integer>> ans,List<Integer> combination,int i){
        if(target == 0){
            //found a combination
            ans.add(new ArrayList<>(combination));
            return;
        }
        if(target < 0 || i == nums.length){
            return;
        }
        combination.add(nums[i]);
        helper(nums,target-nums[i],ans,combination,i);
        combination.remove(combination.size() - 1);
        helper(nums,target,ans,combination,i+1);
    }
}
