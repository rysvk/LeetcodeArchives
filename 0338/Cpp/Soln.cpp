class Solution {
public:
    vector<int> countBits(int n) {
        /**
        DP Approach 

        Since we are counting binary bits, to represent N we need floor(lg(N)) + 1 digits to represent N.
        Hence our approach would be to find subproblems in terms of binary representation (removing left most bit).

        Hence dp[i] => number of 1s in binary representation of i
        dp[i] =     dp[i/2] + 1    => If i is odd
                or  dp[i/2]        => If i is even

        **/
        vector<int> dp(n + 1, 0);
        for(int i = 1; i <= n; i++)
            dp[i] = dp[i>>1] + (i&1);
        return dp;
    }
};