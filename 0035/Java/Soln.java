class Solution {
    public int searchInsert(int[] nums, int target) {
        // Bounds are [0, length or array]
        // Insertion index is always guranteed
        int low = 0;
        int high = nums.length;
        
        while(low < high){
            int mid = low + (high - low)/2;

            // if value at mid == target, we can still insert at mid, so not to discard mid
            if(nums[mid] >= target){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        // low is the smallest value of index such that nums[low]>=target

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
}

/*
Note the following only works as :-
- when the target is smaller than the smallest element, high becomes -1 and low = 0 [ same as the insert index ]
- when the target is larger than the largest element, high becomes nums.length-1 and low becomes nums.length [ same as the insert index ]
- the array is distinct, that is why we could return mid, if not this would give wrong result.

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] > target){
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}

*/