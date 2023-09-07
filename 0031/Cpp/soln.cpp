class Solution {
public:
    // TC : O (n)
    // SC : O (1)
    // Intuition here is to think about how small a change you can make from the right(Least Significant Bit)
    // If you are able to make the smallest change and get the next permutation then that should be the target.
    //
    // Edge case :-
    // Although the case  [3 2 1] => [1 2 3] feels complex to understand, it is really easy to see what we 
    // need to do to get the answer. Essentially if the array is sorted descending manner, we need the 
    // array sorted ascending. 
    //
    // DO WE REALLY SORT the entire array ? NO : Just reverse the entire array[as it is already reverse sorted]
    //
    // For the general case lets take a number and try to visualize it.
    //
    // 6 3 5 4 2 1   => What is the answer =>  6 4 1 2 3 5
    //
    // In general you will see if there is a digit which is less than the next digit to the right.
    // 6 [3] < [5] 4 2 1 => this means 3 can be replaced but lexicographically higher value from its right.
    //
    // We need to choose such a digit from the right side i.e the rightmost i such that : digit[i] < digit[i+1]
    // That should be giving us the next permutation as digits to the left of [3] do not matter.
    // But what digit should replace [3] with ? 
    // ---- It should be the lexicographically smallest value greater than 3 and lying to the left of 3.
    // ---- This case it is 4. So lets replace (swap) them
    // 6 4 5 3 2 1 => Is this the next permutation lexicographically ? NO 
    // NO as from 6 3 x x x x we went to 6 4 x x x x but this is not the lowest value of the permutation.
    // 
    // As 3 < 5 was was the rightmost of such combination, and we replaced 3 with the next higher element from the right.
    // After swapping the part after 6 4 x x x x   would be reverse sorted.
    // 6 4 5 3 2 1  [ 5 3 2 1 is reverse sorted]
    // Now just reverse that part of the array to get 
    // 6 4 1 2 3 5 => THIS GIVES THE NEXT PERMUTATION lexicographically.

    void reverse(vector<int>& nums, int low, int high){
        while(low < high)
            swap(nums[low++],nums[high--]);
    }
    void nextPermutation(vector<int>& nums) {
        int i = nums.size() - 1; // Points to the last index

        // Right to left the first, find first index i such that nums[i] > nums[i-1].
        while(i>0 && nums[i] <= nums[i-1]) 
            i--; 

        if(!i) // i == 0 means we found no such i => array is reverse sorted
            reverse(nums,0,nums.size()-1); // reverse entire array
        else {
            int j = i - 1; 
            // Replace nums[i-1] with the next bigger element from its right. Copy i-1 to j.

            for(i = nums.size() - 1; i > j && nums[i] <= nums[j]; i--);
            // after the loop ends, nums[i] > nums[j] 

            swap(nums[i] , nums[j]);

            reverse(nums, j + 1, nums.size() - 1); // reverse the array from j+1 to the end.
        }
    }
};