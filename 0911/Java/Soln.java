class TopVotedCandidate {
    private int[] times;
    private int[] leader;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times=times;
        leader = new int[persons.length];
        int lead = persons[0];
        Map<Integer,Integer> leadCnt= new HashMap();
        for(int i=0; i<persons.length; i++){
            if(leadCnt.merge(persons[i],1,Integer::sum)>=leadCnt.get(lead))
                lead = persons[i];
            leader[i]=lead;
        }
    }

    private int searchInsertPost(int t){
        int l=0;
        int r=times.length;
        while(l<r){
            int m=l+(r-l)/2;
            if(times[m]==t)
                return m;
            else if(times[m]>t)
                r=m;
            else
                l=m+1;
        }
        return l-1;
    }
    
    public int q(int t) {
        return leader[searchInsertPost(t)];
    }
}

