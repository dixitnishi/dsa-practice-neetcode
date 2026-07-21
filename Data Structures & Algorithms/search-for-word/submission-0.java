class Solution {
    private int rows,cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for(int r = 0;r<rows;r++){
            for(int c = 0;c<cols;c++){
                if(dfs(board,word,r,c,0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board,String word,int r, int c,int i){
        if(i == word.length()) return true; // depicting we have found the the word in board
        if(r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == '#' || board[r][c] != word.charAt(i)){
            // base case basically stop here
            // we cannot find the word through current path
            return false;
        }

        board[r][c] = '#'; // marking this position as visited
        boolean res = dfs(board,word,r+1,c,i+1) ||
            dfs(board,word,r-1,c,i+1) ||
            dfs(board,word,r,c+1,i+1) ||
            dfs(board,word,r,c-1,i+1);
        board[r][c] = word.charAt(i); // remarking the char so to be used for another path
        return res;    
    }
}
