/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // Bounds [1..n(inclusive)]
        int low = 1;
        int high = n;
        // Result is guranteed
        while(low < high){
            int mid = low + (high - low)/2;

            // if mid is bad, none of mid+1 to n can be  first bad version
            if(isBadVersion(mid))
                high = mid;
            else
                low = mid + 1;
        }
        // low is smallest number such that firstBadVersion(low) = true
        return low;
    }
}