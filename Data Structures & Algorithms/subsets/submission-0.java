class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> temp  = new ArrayList<>();
        helper(nums,0,ans,temp,nums.length);
        return ans;
    }

    public void helper(int[] nums,int i,List<List<Integer>> ans,List<Integer> temp,int n){
        if(i == n){
            ans.add(new ArrayList<>(temp));
            
            return;
        }
        temp.add(nums[i]);
        helper(nums,i+1,ans,temp,n);
        temp.remove(temp.size()-1);
        helper(nums,i+1,ans,temp,n);
    }
}
