class Solution {
    public int findMin(int[] nums) {
        /* 
        Since worst case is anyway linear for array of all same values,
        just find if for any element, the adjacent element is lesser than the current.   
        */
        for(int i=0;i<nums.length-1;i++)
            if(nums[i] > nums[i+1]) 
                return nums[i+1];
        return nums[0];
    }
}

/*
TC : O(N)
SC : O(1)

*/