class Solution {
    public int firstInsertionPosition(int[] nums, int target){
        // Bounds are [0 .. length of array]
        // Insertion position is always guranteed.
        int low = 0;
        int high = nums.length;
        while(low < high){ 
            int mid = low + (high - low)/2;

            // Example 
            // target : 4 or 5
            // low    mid-1   mid        high 
            //         3      [5]
            if(nums[mid] >= target)
                high = mid;
            else 
                low = mid + 1;
        }
        // low is the smallest index such that nums[low] >= target

        // Boundary analysis 
        // Case 1:-
        //  mid                        high   
        //  low high target=5   =>     low
        //   4   5                   4  5
        //
        // Case 2:-
        //  mid                     high   
        //  low high target=4   =>  low
        //   4   5                   4  5
        // both cases answer is low or high
        //
        // So high could also be the asnwer;
        // return high;
        return low;
    }
    public int[] searchRange(int[] nums, int target) {
        int firstInsertIndex = firstInsertionPosition(nums, target);

        // if first insert index == nums.length means target not found.
        // also the value at first insert index should be equal to target if it is present.
        if((firstInsertIndex == nums.length) || (nums[firstInsertIndex] != target))
            return new int[] {-1, -1};
        return new int[] { firstInsertIndex, firstInsertionPosition(nums, target + 1) - 1 };
    }
}

