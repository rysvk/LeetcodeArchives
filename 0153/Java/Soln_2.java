class Solution {
    public int findMin(int[] nums) {
        // Bounds will be array indices [0 ..length-1]
        int low = 0;
        int high = nums.length-1;
        // Answer is guranteed
        while(low < high){
            // Since all distinct elements, we can return early when no rotation.
            if(nums[low] <nums[high])
                return nums[low];

            int mid = low + (high - low)/2;

            if(nums[mid] < nums[high])
                high = mid;
            else
                low = mid + 1;
        }
        return nums[low];
    }
}

/*  

Sorted array with no rotation (0 rotation)

           /|
          / | 
         /  |
        /   |
       /    |
      /     |
     /      |
    /       |   
   /        |  
  /         |  
 /          |   
/___________|





Sorted Rotated array
where mid element is in the bigger pulse

         /|
        / | 
       /  |
      /   |
     /    |
    /     |
   /      |
  /       |
 /        | 
|         |    /|
|         |   / |
|         |  /  |
|         | /   |
|_________|/____|

l       m       h
o       i       i
w       d       g
                h


Sorted Rotated array
where mid element is in smaller pulse

    /|
   / | 
  /  |
 /   |
|    |         /|
|    |        / |
|    |       /  |
|    |      /   |
|    |     /    |
|    |    /     |
|    |   /      |
|    |  /       |
|    | /        |
|____|/_________|

l       m       h
o       i       i
w       d       g
                h

*/