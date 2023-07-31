class Solution {
    public int countNegatives(int[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;

        // Rows and columns are sorted descending
        //                              [ 4, 3, 2,-1] 
        //                              [ 3, 2, 1,-1]
        //                              [ 1, 1,-1,-2]
        //   Starting from here ==>     [-1,-1,-2,-3]
        // TC :  O( m + n) 
        // m = # row 
        // n = # column
        int row = nRow-1;
        int col = 0;
        int cnt = 0;
        while(row >= 0 && col < nCol){
            if(grid[row][col] < 0){
                // all values from col to the right are descending and -ve
                cnt += nCol - col;
                row--;
            }
            else
                // value at col in current row is +ve
                col++;
        }
        return cnt;
    }
}