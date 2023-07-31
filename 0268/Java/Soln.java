class Solution {
    public int missingNumber(int[] nums) {
        // Bounds are [ 0, n+1 (exclusive)]
        // result is guranteed
        int low = 0;
        int high = nums.length + 1;
        while(low < high){
            int cntLessorEqual=0; 
            int mid = low + (high - low)/2;

            // count of numbers less than or equal to mid.
            for(int n:nums)
                if(n <= mid)
                    cntLessorEqual++;
            
            // nCountLessorEqual(mid) = mid + 1 [ if 0,1,2,.. m all present]
            // since no duplicates nCountLessorEqual(mid) <= mid+1

            if(cntLessorEqual == mid+1)
                // all from 0 to mid are present
                low = mid + 1;
            else
                // one is missing from 0 to mid(including mid)
                high = mid;
        }
        // low is largest number such that nCountLessorEqual(low) = low + 1 
        return low;
    }
}