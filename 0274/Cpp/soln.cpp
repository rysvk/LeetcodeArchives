class Solution {
public:
    int hIndex(vector<int>& citations) {
        // TC : O(n lgn)
        // SC : O (1)
        //
        // Simplest approach seems to be sorting the citations array.
        // When sorted, the array contains N elements with increasing number of citations.
        //
        // NOTE : Maximum possible value of h - index = N (number of papers published)
        //
        // Lets take an example 
        //
        // [citations[0] citations[1] .... citations[n-1]]  ===> sorted citations
        // citations[i] = number of citations for ith index.
        // number of papers having atleast 'citations[i]' citations = len( [citations[i], citations[i+1] ....citations[n-1]] )
        //    = (n - 1) - i + 1   =  n - i 
        // For h-index  : citations[i] >= n - i .. here H-index = n - i
        // We need to find the maximum value of h-index i.e n-i
        // Or we need to find least value of index i which satisfies citations[i] >= n -i

        sort(begin(citations), end(citations));
        int n = citations.size();
        for(int i = 0; i < n; i++){
            if(citations[i] >= n - i)
                return n - i;
        }
        return 0; // No such i found
    }
};