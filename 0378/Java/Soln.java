class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Bounds = [ min value .. max value in matrix]
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix.length-1];
        // Answer is guranteed as kth smallest value will always exist
        while(low < high){
            int mid = low +(high - low)/2;

            // if nLessThanEqual(mid) >= k dont discard mid
            if(cntLessThanorEqual(matrix, mid) >= k) // if(cntLessThanorEqualV2(matrix, mid) >= k)
                high = mid;
            else 
                low = mid + 1;
        }
        // low is the smallest number such that nLessThanEqual(low) >= k
        // or otherwise nLessThanEqual(low) = k or kth smallest number
        return low;
    }

    // Rows and columns are sorted increasing order
    // [ 1, 5, 9]  <== Starting from the first row last column
    // [10,11,13]
    // [12,13,15]
    public int cntLessThanorEqual(int[][] matrix, int k){
        int row = 0;
        int col = matrix.length-1;
        int cnt = 0;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] > k){
                // decrement col till all numbers in this row are <= k
                col--;
            }
            else {
                // all numbers in current row is <= k
                // add #cols = col+1 
                cnt += col+1;
                row++;
                // go to next row
            }
        }
        return cnt;
    }

    // Rows and columns are sorted increasing order
    //                                             [ 1, 5, 9]  
    //                                             [10,11,13]
    //   Starting from last row first column ==>   [12,13,15]
    public int cntLessThanorEqualV2(int[][] matrix, int k){
        int row = matrix.length-1;
        int col = 0;
        int cnt = 0;
        while(row >=0 ){
            // increment col till the value <= k
            while(col < matrix.length && matrix[row][col] <= k)
                col++;

            // col is the column where value > k 
            cnt += col;

            row--;
            //move to upper row
        }
        return cnt;
    }
}