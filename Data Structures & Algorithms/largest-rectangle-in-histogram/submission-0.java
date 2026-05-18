class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int maxi = -1;
        for(int i = 0;i<heights.length;i++){
            int start = i;
            while(!st.isEmpty() && st.peek()[1] > heights[i]){
                int[] temp = st.pop();
                maxi = Math.max(maxi,temp[1] * (i-temp[0]));
                start = temp[0];
            }
            st.push(new int[]{start,heights[i]});
        }

        int n = heights.length;
        while(!st.isEmpty()){
            int temp[] = st.pop();
            maxi = Math.max(maxi,temp[1] * (n - temp[0]));
        }
        return maxi;
    }
}
