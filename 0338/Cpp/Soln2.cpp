class Solution {
public:
    vector<int> countBits(int n) {
        /**
        DP Approach 

        Since we are counting binary bits, to represent N we need floor(lg(N)) + 1 digits to represent N.
        Remember the trick to set the leftmost 1 bit to 0.

        x = x & (x-1)  -> This sets the leftmost 1 in x to 0

        Hence dp[i] => dp[ i & (i-1)] + 1 ;

        **/
        vector<int> dp(n + 1, 0);
        for(int i = 1; i <= n; i++)
            dp[i] = dp[i&(i-1)] + 1;
        return dp;
    }
};