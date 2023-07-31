class Solution {
    public int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length ;
        while(low <= high){
            if( low == high )
                return low;
            int cntLessorEqual=0;
            int mid = low + (high - low)/2;
            for(int n:nums)
                if(n <= mid)
                    cntLessorEqual++;
            if(cntLessorEqual < mid+1)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}