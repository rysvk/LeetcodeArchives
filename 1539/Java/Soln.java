class Solution {
    public int findKthPositive(int[] arr, int k) {
        // Bounds [Array indexes 0 .. length-1]
        // Result is guranteed as we will always find a number missing
        int low = 0;
        int high = arr.length;

        while(low < high){
            int mid = low + (high - low)/2;

            // Example 
            //  Index         0  1  2  3  4
            //  Array         1  3  5  6  9
            // nMissing       0  1  2  2  4
            // nMissing(index) = arr[index] - (index+1)  
            int nMissingMid = arr[mid] - (mid+1);

            // Dont discard mid as mMissingMid >= k
            if(nMissingMid >= k)
                high = mid;
            else
                low = mid + 1;
        }
        // A[low] : First index where A[index] has nMissing >= k
        // number of missing numbers at index low -1 =  nMissing(low-1) 
        // Hence kth missing = A[low-1] + (k - nMissing(low - 1)) 
        // kth missing = A[low-1] + k - ( A[low - 1] - (low -1 + 1) )
        // kth missing = A[low-1] + k + low -A[low-1]
        // kth missing = k + low
        return low +k;
    }
}
