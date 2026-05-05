class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Identify the smaller length array out of 2 
        // calulate the total and half
        int[] A  = nums1;
        int[] B = nums2;
        

        int total  = A.length + B.length;
        int half = (total+1)/2;
        // binary search
        if(B.length < A.length){
            int[] temp = A;
            A = B;
            B = temp;
        }
        int l = 0;
        int r = A.length; //  ?? why this and not A.length-1;
        while(l<=r){
            int i = (l+r)/2; // calculating the mid
            int j = half - i ; // ?? Still not clear on this one

            int aLeft = i > 0 ? A[i-1] : Integer.MIN_VALUE;
            int aRight = i < A.length ? A[i] : Integer.MAX_VALUE;

            int bLeft = j > 0 ? B[j-1] : Integer.MIN_VALUE;
            int bRight = j < B.length ? B[j] : Integer.MAX_VALUE;

            if(aLeft <= bRight && bLeft <= aRight){
                // Valid partition
                if(total % 2 != 0){
                    return Math.max(aLeft,bLeft);
                }else{
                    return (Math.max(aLeft,bLeft) + Math.min(aRight,bRight))/2.0;
                }
            }
            // Not correct partition cases
            else if(aLeft > bRight){
                r = i - 1;
            }
            else{
                l = i + 1;
            }
        }
        return -1;

    }
}
