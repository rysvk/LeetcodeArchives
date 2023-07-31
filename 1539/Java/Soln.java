class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = low + (high - low)/2;
            int nMissing = arr[mid] - (mid+1);
            if(nMissing >= k)
                high = mid;
            else
                low = mid + 1;
        }
        // A[low] : First index where A[index] has nMissing >= k
        // Hence kth missing = A[low-1] + (k - nMissing(low - 1)) 
        // kth missing = A[low-1] + k - ( A[low - 1] - (low) )
        // kth missing = A[low-1] + k + low -A[low-1]
        // kth missing = k + low
        return low +k;
    }
}
