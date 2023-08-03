class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Essentially the entire 2D array is sorted, if we flatten 
        // it to 1D array, row major.
        // Total numbers in the flattened 1D array = m x n
        
        int nCols = matrix[0].length;
        int nRows = matrix.length;

        // Bounds are hypothetical indices of the flattened 1D array
        int low = 0;
        int high = nRows * nCols - 1 ;
        

        // Answer is not guranteed 
        while(low <= high){
            int mid = low + (high - low)/2;


            if(matrix[mid/nCols][mid%nCols] == target)
                return true;
            else if(matrix[mid/nCols][mid%nCols] > target)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return false;
    }
}

/*
TC : O(log mn)
SC : O(1)
*/
