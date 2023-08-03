class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        int row = 0;
        int col = nCols - 1 ;

        /*
            [  1,  4,  7, 11, 15]  <== Starting from this corner
            [  2,  5,  8, 12, 19]
            [  3,  6,  9, 16, 22]
            [ 10, 13, 14, 17, 24]
            [ 18, 21, 23, 26, 30]  
        */

        while(row < nRows && col >= 0){
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] > target)
                col--;
            else 
                row++;
        }
        return false;
    }
}

/*
TC : O(m + n)
SC : O(1)
*/
