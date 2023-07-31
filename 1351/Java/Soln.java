class Solution {
    public int countNegatives(int[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;

        // Rows and columns are sorted descending
        //   [ 4, 3, 2,-1] <== Starting from here
        //   [ 3, 2, 1,-1]
        //   [ 1, 1,-1,-2]
        //   [-1,-1,-2,-3]
        // TC :  O( m + n) 
        // m = # row 
        // n = # column
        int row = 0;
        int col = nCol-1;
        int cnt = 0;
        while(row < nRow){
            // decrement col till values are -ve
            while(col >= 0 && grid[row][col]<0)
                col--;
            
            // col is -1 (whole row -ve) or the smallest +ve value
            cnt += nCol - (col + 1);

            // go to next row
            row ++;
        }
        return cnt;
    }

}