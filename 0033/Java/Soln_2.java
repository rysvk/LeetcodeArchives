class Solution {
    public int search(int[] nums, int target) {
        // Bounds are array indices [0 .. length-1]
        int low = 0;
        int high = nums.length - 1;

        // answer is not guranteed.
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target)
                return mid;
            // [low ... mid] is sorted   
            // NOTE : <= and not < as if high-low =1 then mid = low 
            else if(nums[low] <= nums[mid]){
                // target lies in [low ... mid-1]
                if(nums[mid] > target && nums[low] <= target)
                    high = mid - 1;
                else 
                    low = mid + 1;
            }
            // [mid+1 ... high] is sorted 
            else {
                // if target lies in [mid+1 ... high]
                if(nums[high] >= target && nums[mid] < target)
                    low = mid + 1;
                else
                    high = mid -1;
            }
        }
        return -1;
    }
}