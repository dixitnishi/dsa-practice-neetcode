class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(0,0,n,"",ans);
        return ans;
    }

    public void backtrack(int open,int close,int n,String curr,List<String> ans){
        if(open == close && open + close == 2*n){
            ans.add(curr);
            return;
        }

        if(open < n){
            backtrack(open+1,close,n,curr+"(",ans);
        }
        if(close < open){
            backtrack(open,close+1,n,curr+")",ans);
        }
    }
}
