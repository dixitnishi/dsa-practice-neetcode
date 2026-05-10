class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int [] ans  = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                int curr = st.pop();
                ans[curr] = i-curr;
            }
            st.push(i);

        }
        return ans;
    }
}
