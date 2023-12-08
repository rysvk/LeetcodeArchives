class Solution {
public:
    int climbStairs(int n) {
        /**
        DP Approach(Space Optimized) : This is one of the easiest DP, but DP(space optimized) is not optimal for this problem.
        TC : O(N), SC : O(1)
        There are better ways to solve this problem :-
        2. Matrix Exponentiation for finding Nth Fibonacci


        However lets explore the DP approach here.

        Lets assume dp[i] => 'Number of Ways' to reach step i;

        Naturally dp[0] = 1    [ Only one way to reach step 0, where we start ]
        Also      dp[1] = 1    [ Jump 1 from 0 to 1 ]
        Also      dp[2] = 2    [ Jump 1 from 1 or jump 2 from 0 ... hence summation of ways to reach 0 and 1 ]

        Hence dp[n] = dp[n-1] + dp[n-2]

        In Space optimized DP we just track the latest two answers :-
        Lets say a = dp[0], b = dp[1],
        Then to calculate dp[2] we can just calculate a+b, and get back the previous result by subtracting a from (a+b).

        **/

        int a = 1;
        int b = 1;
        for(int i = 2; i <= n; i++)
            b+=a, a=b-a;
        
        return b;
    }
};