class Solution {
    // TC :  O( m  * lg n) 
    // m = # row 
    // n = # column
    // NOTE : O(m+n) is better than O( m * lgn)
    // Example :-
    // M = 1000
    // N = 1000
    // M+N = 2000
    // M x lg N = 1000 * 10(approx) = 10000
    // Avoid this method 

    // O(lg n)
    public int firstInsertIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] <= target)
                high = mid;
            else 
                low = mid + 1;
        }
        return low;
    }
    // O(m * lgn)
    public int countNegatives(int[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;
        int cnt = 0;
        for(int i = 0; i < nRow; ++i){
            cnt += nCol - firstInsertIndex(grid[i], -1);
        }
        return cnt;
    }
}