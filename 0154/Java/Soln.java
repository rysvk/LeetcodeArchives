class Solution {
    public int findMin(int[] nums) {
        // Bounds are array indices [0.. length-1]
        int low = 0;
        int high = nums.length -1;
        // Answer is guranteed in the range
        while(low < high){
            int mid = low + (high-low)/2;
            // can only discard high as minimum can be anywhere in the array
            if(nums[mid] == nums[high])
                high --;
            else if(nums[mid] < nums[high])
                high = mid;
            else 
                low = mid + 1;
        }
        return nums[low];
    }
}

/*
TC : O(N)
SC : O(1)

========================================================
When nums[mid] == nums[high], MINIMUM can be anywhere, 
hence only discard high 
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
-

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

========================================================

*/