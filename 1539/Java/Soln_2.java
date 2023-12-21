class Solution {
    public int findKthPositive(int[] arr, int k) {
        // Interesting fact to note : arr[i]-i-1  = Total Missing numbers till index 'i'
        // Bounds : 0 .. size(arr) 
        // [If the number of missing in last index is less than k then all the missing will be found after last index]
        // Fact is we are searching for number of missing positives at a particular index i[0..size(arr)]
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = low + ((high-low)>>>1);
            if(arr[mid] - mid - 1 >= k)
                high = mid;
            else
                low = mid + 1;
        }
        // low is the lowest index s.t. number of missing postives >=k
        // low can also be size(arr), in that case we cannot write number :-
        // of missing positives = arr[arr.length]-arr.length-1 as that would be invalid.
        // Let us derive the kth missing number, ignoring this for now as inside while loop mid will never be equal to size(arr)
        
        // The missing positive would lie between (arr[low-1]..arr[low])
        // Number of missing positives at index low - 1 : arr[low-1] - (low-1) - 1 = arr[low-1] - low
        // Number of extra mising positives required after arr[low-1] = k - [ arr[low-1] - (low-1) - 1 ]
        // Hence the missing numbers would start from arr[low-1]+1, arr[low-1]+2 ...
        // the desired number = arr[low-1] + k - [ arr[low-1] - (low-1) - 1 ] 
        // = arr[low-1] + k - [arr[low-1] - low]
        // = arr[low-1] + k -arr[low-1] + low
        // = low + k
        
        // As derived the missing positive number has no dependency or arr size or index.

        return low + k;
    }
}