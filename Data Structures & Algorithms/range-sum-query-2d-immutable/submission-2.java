class NumMatrix {
    
    int [][] matrix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        this.matrix = new int[rows][cols];
        for(int row = 0;row < rows;row++){
            this.matrix[row][0] = matrix[row][0];
            for(int col = 1;col<cols;col++){
                this.matrix[row][col] = this.matrix[row][col-1] + matrix[row][col];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1;i<=row2;i++){
            if(col1 > 0){
                sum += matrix[i][col2] - matrix[i][col1-1];
            }else{
                sum += matrix[i][col2];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */