class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(candidates,target,0,combination,res);
        return res;
    }

    public void dfs(int[] candidates,int target,int i,List<Integer> combination,List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(combination));
            return;
        }
        if(target < 0 || i == candidates.length){
            return;
        }
        combination.add(candidates[i]);
        dfs(candidates,target - candidates[i],i+1,combination,res);
        combination.remove(combination.size() - 1);
        int nextIdx = upperBound(candidates,i,candidates[i]);
        dfs(candidates,target,nextIdx,combination,res);
    }

    public int upperBound(int[] nums,int i,int target){
        int l = i;
        int r = nums.length-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] > target){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }
}
