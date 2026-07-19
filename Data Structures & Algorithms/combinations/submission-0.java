class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(1, n, k, combination, ans);
        return ans;
    }

    public void dfs(int i, int n, int k, List<Integer> combination, List<List<Integer>> res) {
        if (i > n) {
            if (combination.size() == k) {
                res.add(new ArrayList<>(combination));
            }
            return;
        }
        combination.add(i);
        dfs(i + 1, n, k, combination, res);
        combination.remove(combination.size() - 1);
        dfs(i + 1, n, k, combination, res);
    }
}