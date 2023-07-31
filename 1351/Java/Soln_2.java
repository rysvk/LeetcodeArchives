class Solution {
    public int countNegatives(int[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;
        int row = nRow-1;
        int col = 0;
        int cnt = 0;
        while(row >= 0 && col < nCol){
            if(grid[row][col] < 0){
                cnt += nCol - col;
                row--;
            }
            else
                col++;
        }
        return cnt;
    }
}