class Solution {
    public int search(int[] nums, int target) {
        // Bounds [0.. length of array-1 (inclusive)]
        int low = 0;
        int high = nums.length - 1;
        // answer is not gurnteed
        while(low <= high) { 
            int mid = low + (high - low)/2; 
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return -1;
    }
}