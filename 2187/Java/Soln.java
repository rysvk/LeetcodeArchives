class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        int min = time[0];
        for(int t:time)
            min = Math.min(min, t);
        long high = min * (long)totalTrips;

        while(low < high){
            long mid = low + (high - low)/2;

            if(getTripsWithinTime(mid, time) < totalTrips)
                low = mid + 1;
            else 
                high = mid;
        }
        return low;
    }
    public long getTripsWithinTime(long time, int[] times){
        long cntTrips = 0;
        for(int t:times)
            cntTrips += time/t;
        return cntTrips;
    }
}