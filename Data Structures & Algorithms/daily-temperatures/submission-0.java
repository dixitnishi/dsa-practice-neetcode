class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int [] ans  = new int[n];
        for(int i = 0;i<n;i++){
            int j = i+1;
            while(j < n && !(nums[j] > nums[i])) j++;
            if(j < n){
                ans[i] = j-i;
            }
        }
        return ans;
    }
}
