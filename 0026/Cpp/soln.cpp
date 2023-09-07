class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        // TC : O (n) 
        // SC : O (1)
        //
        // The process is similar to sedimentation. Whenever you want to return an array
        // where the resulting array will have the same order but less in size, this is 
        // what we should do.
        // 
        // 1. Let us define index i which iterates through all the array elements. Initially 0.
        // 2. Let us define index j which is the length of the resulting array. Initially 0
        // 3. Whenever you get a favourable outcome for the current element at index i
        //    copy the value of arr[i] -> arr[j] and increment j by 1.
        //  
        // [arr[0] arr[1] arr[2] ..................arr[n-1]] arr
        // 
        // Since in this problem the first element is guranteed to be present in the result array
        // we would initialize j = 1 [has one element] and iterate through all elements but the 
        // first one i.e. i=1.

        int j = 1;
        for(int i = 1; i < nums.size(); ++i){
            if( nums[i] != nums[i-1]) { 
                // No duplicate, hence a favourable outcome.
                nums[j++] = nums[i];
            }
        }
        return j;
    }
};