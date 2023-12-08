class Solution {
public:
    int climbStairs(int n) {
        /**
        DP Approach : This is one of the easiest DP, but DP is not optimal for this problem.
        TC : O(N), SC : O(N)
        There are better ways to solve this problem :-
        1. Space optimized DP (Just take the last two results)
        2. Matrix Exponentiation for finding Nth Fibonacci


        However lets explore the DP approach here.

        Lets assume dp[i] => 'Number of Ways' to reach step i;

        Naturally dp[0] = 1    [ Only one way to reach step 0, where we start ]
        Also      dp[1] = 1    [ Jump 1 from 0 to 1 ]
        Also      dp[2] = 2    [ Jump 1 from 1 or jump 2 from 0 ... hence summation of ways to reach 0 and 1 ]

        Hence dp[n] = dp[n-1] + dp[n-2]

        **/

        vector<int> dp(n+1, 1);
        for(int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        
        return dp[n];
    }
};