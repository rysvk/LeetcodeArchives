class Solution {
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