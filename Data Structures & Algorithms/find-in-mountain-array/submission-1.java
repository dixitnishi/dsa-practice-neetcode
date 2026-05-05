/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 1;
        int r = n-2;
        int idx = 0;
        while(l <= r){
            int m = (l+r)/2;
            int left = mountainArr.get(m-1);
            int mid = mountainArr.get(m);
            int right = mountainArr.get(m+1);
            if(left < mid && mid < right){
                l = m + 1;
            }
            else if(left > mid && mid > right){
                r = m -1;
            }
            else{
                idx = m;
                break;
            }
        }

        l = 0;
        r = idx -1;
        while(l<=r){
            int mid = (l+r)/2;
            int val = mountainArr.get(mid);
            if(val == target){
                return mid;
            }
            else if(val < target){
                l = mid +1;
            }
            else{
                r = mid -1;
            }
        }

        l = idx;
        r = n-1;
        while(l<=r){
            int mid = (l+r)/2;
            int val = mountainArr.get(mid);
            if(val == target){
                return mid;
            }
            else if(val > target){
                l = mid +1;
            }
            else{
                r = mid -1;
            }
        }
        return -1;
    }
}