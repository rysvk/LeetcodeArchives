class HitCounter{
    // since only max 300 calls for hit, we can pre-allocate memory
    private int[] nhits = new int[300];
    private int[] timestamps = new int[300];

    public void hit(int timestamp){
        int ts = timestamp % 300;
        // modulus of timestamp by total max hits to find the bucket for this timestamp
        
        // When the current bucket ts is for the same timestamp
        if(timestamps[ts] == timestamp)
            nhits[ts] ++;
        // When the current bucket ts is for a timestamp 300xN seconds earlier
        else {
            timestamps[ts] = timestamp;
            nhits[ts] = 1;
        }
    }

    public int getHits(int timestamp){
        int cnt = 0;
        // gather all hits for timestamps within the 5 minutes
        for(int i = 0; i < 300; ++i){
            if(timestamp - timestamps[i] < 300)
                cnt += nhits[i];
        }

        return cnt;
    }
}

/*
TC : O(1)
SC : O(1)
*/