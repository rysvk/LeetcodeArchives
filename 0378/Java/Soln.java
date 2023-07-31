class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix.length-1];
        while(low < high){
            int mid = low +(high - low)/2;
            if(cntLessThanorEqualV2(matrix, mid) >= k)
                high = mid;
            else 
                low = mid + 1;
        }
        return low;
    }
    public int cntLessThanorEqual(int[][] matrix, int k){
        int row = 0;
        int col = matrix.length-1;
        int cnt = 0;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] > k){
                col--;
            }
            else {
                cnt += col+1;
                row++;
            }
        }
        return cnt;
    }
    public int cntLessThanorEqualV2(int[][] matrix, int k){
        int row = matrix.length-1;
        int col = 0;
        int cnt = 0;
        while(row >=0 ){
            while(col < matrix.length && matrix[row][col] <= k)
                col++;
            cnt += col;
            row--;
        }
        return cnt;
    }
}