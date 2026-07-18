class Solution {
    public int findKthLargest(int[] nums, int k) {
        // quick select algorithm
        k = nums.length - k;
        return quickSelect(nums, 0 , nums.length-1,k);
    }

    public int quickSelect(int nums[],int l,int r,int k){
        int pivotElem = nums[r];
        int pivot = l;
        for(int i = l ; i<r; i++){
            if(nums[i] <= pivotElem){
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                pivot++;
            }
        }

        int temp = nums[pivot];
        nums[pivot] = nums[r];
        nums[r] = temp;

        if(pivot > k) return quickSelect(nums,l,pivot - 1,k);
        else if(pivot < k) return quickSelect(nums,pivot + 1,r,k);
        else return nums[pivot];
    }
}
