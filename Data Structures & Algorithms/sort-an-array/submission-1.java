class Solution {
    public int[] sortArray(int[] nums) {
        // mergeSort(nums,0,nums.length-1);
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int nums[],int i,int j){
        if(i>=j) return;
        int pivot = partition(nums,i,j);
        quickSort(nums,i,pivot-1);
        quickSort(nums,pivot+1,j);
    }

    public int partition(int[] nums,int i,int j){
        int pivotElem = nums[i];
        int low = i;
        int high = j;
        while(low < high){
            while(nums[low] <= pivotElem && low <= j-1){
                low++;
            }
            while(nums[high] > pivotElem && high >= i+1){
                high--;
            }
            if(low < high){
                swap(nums,low,high);
            }
        }
        swap(nums,i,high);
        return high;
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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