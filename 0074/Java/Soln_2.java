class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        int row = 0;
        int col = nCols - 1 ;

        /*
            [ 1, 3, 5, 7]  <== Starting from this corner
            [10,11,16,20]
            [23,30,34,60]
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
