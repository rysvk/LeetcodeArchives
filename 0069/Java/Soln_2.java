class Solution {
    private int a =1;
    public int mySqrt(long x) {
        long low = 1;
        long high = x + a;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (mid > x / mid)
                high = mid;
            else
                low = mid + 1;
        }

        // low: smallest number such that low * low > x
        return (int)low - 1;
    }
}