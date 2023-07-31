class Solution {
    public int firstPosition(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int firstIndex = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
            if(nums[mid] == target)
                firstIndex = mid;
        }
        return firstIndex;
    }
    public int lastPosition(int [] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int lastIndex = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] <= target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
            if(nums[mid] == target)
                lastIndex = mid;
        }
        return lastIndex;
    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{ firstPosition(nums, target), lastPosition(nums, target)};
    }
}

