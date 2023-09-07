class Solution {
public:
    int hIndex(vector<int>& citations) {
        // TC : O(n)
        // SC : O(n)
        //
        // Sorting solves the problem in O(n lgn) with O(1) space.
        // Therefore we can probably optimize TC to O(n) with extra space O(n).
        //
        // NOTE maximum value of h-index = number of papers = Size of citations = N
        //
        // Let us count the number of papers having citations = [1 .. N]
        // For every paper having citations > N we can count it as N as h-index max value is N
        //
        // cnt[i] => total number of papers having 'i' citatioms
        // 
        // Once we have this count we have :-
        // cnt[i] => total published papers having citation = i
        // For H- index we 
        // We need to find maximum value of index i such that cnt[i] + cnt[i+1] + ...cnt[n] > i
        //
        // To store cnt[i+1] + ... cnt[n] we iterate i = n to 1 and keep adding cnt[i] to
        // totalCntGreater (initially 0).

        int n = citations.size();
        vector<int> cnt(n + 1);

        for(int citation : citations)
            cnt[min(citation, n)]++;

        int totalCntGreater = 0;
        for(int i = n; i > 0; i--){
            if(cnt[i] + totalCntGreater >= i)
                return i;
            totalCntGreater += cnt[i];
        }
        return 0; // No such i found
    }
};