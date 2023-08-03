class Solution {
    public int findMin(int[] nums) {
        // Bounds are array indices [0 .. length -1]
        int low = 0;
        int high =nums.length - 1;
        // Answer is guranteed in the range
        while(low < high) {
            int mid = low + (high-low)/2;

            // if element at low, high and mid are equal, get rid of both low and high
            if(nums[mid] == nums[low] && nums[high] == nums[mid]){
                high--;
                low++;
            }
            // nums[low] will always be greater, refer below.
            else if(nums[mid] <= nums[high]){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return nums[low];
    }
}

/*
TC : O(N)
SC : O(1)

========================================================

// This will be taken care of by the first check
 ________________________________________
|                    |                   |
|                    |                   |
|                    |                   |
|                    |                   |
|                    |                   |
|                    |                   |
|____________________|___________________|

l                    m                   h
o                    i                   i
w                    d                   g
                                         h


This will also be taken care by the first check
                             ____
                       _____/    |
 _____________________/          |   _____
|                    |           |  /    | 
|                    |           | /     |
|                    |           |/      |
|                    |                   |
|____________________|___________________|
l                    m                   h
o                    i                   i
w                    d                   g
                                         h

When nums[mid], nums[low] and nums[high] all 3 are not equal,
but nums[mid] == nums[high], nums[low] will always be greater. 
Hence discard entire right half[mid+1 .. high]
            ____
 __________/    |
|               |    ____________________
|               |   /|                   | 
|               |  / |                   |
|               | /  |                   |
|               |/   |                   |
|_______________|____|___________________|
l                    m                   h
o                    i                   i
w                    d                   g
                                         h


The below one is not possible as there cannot be two troughs in a rotated sorted array
NOT POSSIBLE
            ____
   ________/    |
  /             |    ____________________
 /              |   /|                   | 
/               |  / |                   |
|               | /  |                   |
|               |/   |                   |
|_______________|____|___________________|
l                    m                   h
o                    i                   i
w                    d                   g
                                         h

========================================================

*/