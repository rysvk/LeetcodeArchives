class HitCounter{
    // since max 300 hits, we can pre allocate 
    private int[] nhits = new int[300];
    private int hCount=0;

    public void hit(int timestamp){
        nhits[hCount ++] = timestamp;
    }

    private int findInsertPosition(int target){
        // Boundary is [0 .. length or array]
        int low = 0;
        int high = hCount;
        // Answer is guranteed

        while(low < high){
            int mid = low + (high - low)/2;
            if(nhits[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        // low is the smallest index such that nhits[low] >= target
        return low;
    }

    public int getHits(int timestamp){
        return hCount-findInsertPosition(timestamp-299);
    }
}

/*
TC : O(lg N)
SC : O(1)
*/