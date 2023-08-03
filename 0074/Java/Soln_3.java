class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        int row = nRows - 1;
        int col = 0 ;

        /*
                                            [ 1, 3, 5, 7]  
                                            [10,11,16,20]
           Starting from this corner  ==>   [23,30,34,60]
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
