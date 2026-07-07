class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    public void mergeSort(int[] nums,int i,int j){
        if(i >= j) return;
        int mid = (i+j)/2;
        mergeSort(nums,i,mid);
        mergeSort(nums,mid+1,j);
        merge(nums,i,mid,j);
    }

    public void merge(int[] nums, int i,int mid,int j){
        List<Integer> temp = new ArrayList<>();
        int l = i;
        int r = mid+1;
        while(l <= mid && r <= j){
            if(nums[l] <= nums[r]){
                temp.add(nums[l]);
                l++;
            }else{
                temp.add(nums[r]);
                r++;
            }
        }
        while(l<=mid){
            temp.add(nums[l++]);
        }
        while(r <= j){
            temp.add(nums[r++]);
        }
        for(int k = i;k<=j;k++){
            nums[k] = temp.get(k-i);
        }
    }
}