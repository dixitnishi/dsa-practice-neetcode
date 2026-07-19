class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0,nums.length);
    }

    public int helper(int[] nums,int i,int sum,int n){
        if(i == n){
            return sum;
        }
        return helper(nums,i+1,sum^nums[i],n) + helper(nums,i+1,sum,n);
    }
}