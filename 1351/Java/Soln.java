class Solution {
    public int countNegatives(int[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;
        int row = 0;
        int col = nCol-1;
        int cnt = 0;
        while(row < nRow){
            while(col >= 0 && grid[row][col]<0)
                col--;
            cnt += nCol - (col + 1);
            row ++;
        }
        return cnt;
    }
}