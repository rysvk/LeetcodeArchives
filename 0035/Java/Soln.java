class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
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