class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefixArr[] = new int[nums.length];
        int suffixArr[] = new int[nums.length];
        int ans[] = new int[nums.length];
        int prefix = 1;
        int suffix = 1;
        prefixArr[0]  = 1;
        suffixArr[nums.length-1] = 1;
        for(int i = 1;i<nums.length;i++){
            prefixArr[i] = nums[i-1] * prefixArr[i-1];
        }

        for(int i = nums.length-2;i>=0;i--){
            suffixArr[i] = nums[i+1] * suffixArr[i+1];
        }

        for(int i = 0;i<nums.length;i++){
            ans[i] = prefixArr[i] * suffixArr[i];
        }

        return ans;
    }
}  
