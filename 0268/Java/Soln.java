class Solution {
    public int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length + 1;
        while(low < high){
            int cntLessorEqual=0;
            int mid = low + (high - low)/2;
            for(int n:nums)
                if(n <= mid)
                    cntLessorEqual++;
            if(cntLessorEqual >= mid+1)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}