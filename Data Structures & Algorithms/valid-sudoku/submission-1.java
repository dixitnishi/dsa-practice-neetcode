class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> rows = new HashMap<>();
        HashMap<Integer, Set<Character>> cols = new HashMap<>();
        HashMap<String, Set<Character>> sq = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.')
                    continue;
                String sqKey = (r/3)+","+(c/3);    
                char ch = board[r][c];
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(ch)
                    || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(ch)
                    || sq.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(ch)) {
                    return false;
                }
                rows.get(r).add(ch);
                cols.get(c).add(ch);
                sq.get(sqKey).add(ch);
            }
        }
        return true;
    }
}
