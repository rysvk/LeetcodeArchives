class Solution {
    public int search(int[] nums, int target) {
        // [l, h) approach : Find the insertion Index
        // if the insertion index = size(nums) or nums[insertion_index]!= target return not found
        int low = 0;
        int high = nums.length;
        while(low < high){
            int mid = low + ((high - low)>>1);
            if(nums[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        return (low==nums.length || nums[low]!=target) ? -1:low;
    }
}