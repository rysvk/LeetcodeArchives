class Solution {
    public int firstPosition(int[] nums, int target){
        // Bounds are array indices [0 .. length-1]
        // asnwer is not guranteed ( may not be present )
        int low = 0;
        int high = nums.length - 1;
        int firstIndex = -1; // assume not present

        while(low <= high){
            int mid = low + (high - low)/2;

            // Since we need first index, discard any values >= mid.
            // As if nums[mid]==target no index > mid can be the first index of target.
            if(nums[mid] >= target){ 
                high = mid-1;
            }
            else {
                low = mid+1;
            }

            // store the index if it matches
            if(nums[mid] == target)
                firstIndex = mid;
        }
        return firstIndex;
    }
    public int lastPosition(int [] nums, int target){
        // Bounds are array indices [0 .. length-1]
        // asnwer is not guranteed ( may not be present )
        int low = 0;
        int high = nums.length - 1;
        int lastIndex = -1;  // assume not present
        while(low <= high){
            int mid = low + (high - low)/2;

            // Since we need last index, discard any values <= mid.
            // As if nums[mid]==target no index <mid can be the last index of target.
            if(nums[mid] <= target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }

            // store the index if it matches
            if(nums[mid] == target)
                lastIndex = mid;
        }
        return lastIndex;
    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{ firstPosition(nums, target), lastPosition(nums, target)};
    }
}

