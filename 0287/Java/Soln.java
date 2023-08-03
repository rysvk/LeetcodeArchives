class Solution {
    public int findDuplicate(int[] nums) {
        // Bound [1 ..n]
        int low = 1;
        int high = nums.length - 1;

        // Answer is guranteed 
        while(low < high){
            int mid = low + (high - low)/2;

            int cntLessorEqual =0;
            for(int num : nums)
                if(num <= mid)
                    cntLessorEqual ++;
            
            if(cntLessorEqual <= mid)
                low = mid + 1;
            else
                high = mid;
        }
        // low is smallest number such that cntLessorEqual[low] > low
        return low;
    }
}