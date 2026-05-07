class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int num : nums){
            low = Math.max(low,num);
            high += num;
        }
        int [] prefix  = new int[nums.length+1];
        for(int i = 0;i<nums.length;i++){
            prefix[i+1] = nums[i] + prefix[i];
        }

        int res = high;

        while(low <= high){
            int mid  = (low + high)/2;
            if(canSplit(nums,prefix,k,mid)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }

    private boolean canSplit(int nums[],int prefix[],int k,int limit){
        int arrays = 0;
        int i = 0;
        int n = nums.length;

        while(i < n){
            int l = i+1;
            int r = n;
            while( l<=r){
                int mid = (l+r)/2;
                if(prefix[mid] - prefix[i] <= limit){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
            arrays++;
            i = r;
            if(arrays > k) return false;

        }
        return true;
    }

}