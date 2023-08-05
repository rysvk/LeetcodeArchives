class Solution {
    public int findPeakElement(int[] nums) {
         // Bounds are array indices [0 .. length-1]
        int low = 0;
        int high = nums.length - 1;

        /* Answer qould be guranteed.
        Lets consdider indices mid and mid+1

               |
        [      | |      ]  => peak can lie to the left half as either mid .. low are monotonically increasing,
         l     m m    h       then low is the peak or else we would get one peak in [low..mid]
         o     i i    i
         w     d d    g
                 +    h
                 1

                 |
        [      | |      ]  => peak can lie to the righ half as either mid+1 .. high are monotonically increasing,
         l     m m    h       then high is the peak or else we would get one peak in [mid+1..high]
         o     i i    i
         w     d d    g
                 +    h
                 1
        */
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= nums[mid + 1]){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        /* Boundary analysis 
           |                     |
           |    |       ====>    |     |             ans = low, high
          low  high             low
          mid                   mid
                               high

                |                      |
           |    |       ====>    |     |             ans = low, high
          low  high                   high
          mid                   mid   low
                                      
        
        */
        return low;
        // return high
    }
}