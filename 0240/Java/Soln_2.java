class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        int row = nRows - 1;
        int col = 0 ;

        /*
                                          [  1,  4,  7, 11, 15]
                                          [  2,  5,  8, 12, 19]
                                          [  3,  6,  9, 16, 22]
                                          [ 10, 13, 14, 17, 24]
           Starting from this corner ==>  [ 18, 21, 23, 26, 30]  
        */

        while(row >=0 && col < nCols){
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] > target)
                row--;
            else 
                col++;
        }
        return false;
    }
}

/*
TC : O(m + n)
SC : O(1)
*/
