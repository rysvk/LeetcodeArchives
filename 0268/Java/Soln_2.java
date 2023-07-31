class Solution {
    public int missingNumber(int[] nums) {
        // Bounds [ 0 to n (inclusive) ]
        // result is guranteed
        int low = 0;
        int high = nums.length ;
        while(low <= high){
            // result is guranteed hence low == high means found
            if( low == high )
                return low;
            int cntLessorEqual=0;
            int mid = low + (high - low)/2;

            // count of numbers less than or equal to mid.
            for(int n:nums)
                if(n <= mid)
                    cntLessorEqual++;
            
            // nCountLessorEqual(mid) = mid + 1 [ if 0,1,2,.. m all present]
            // since no duplicates nCountLessorEqual(mid) <= mid+1

            if(cntLessorEqual < mid+1)
                // 0 to mid not all present(including mid)
                high = mid;
            else
                // 0 to mid all present
                low = mid + 1;
        }
        // low is the largest number such that nCountLessorEqual(low) = low + 1 
        return low;
    }
}