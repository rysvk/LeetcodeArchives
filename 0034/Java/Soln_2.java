class Solution {
    public int firstInsertionPosition(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target)
                high = mid;
            else 
                low = mid + 1;
        }
        return low;
    }
    public int[] searchRange(int[] nums, int target) {
        int firstInsertIndex = firstInsertionPosition(nums, target);
        if((firstInsertIndex == nums.length) || (nums[firstInsertIndex] != target))
            return new int[] {-1, -1};
        return new int[] { firstInsertIndex, firstInsertionPosition(nums, target + 1) - 1 };
    }
}

