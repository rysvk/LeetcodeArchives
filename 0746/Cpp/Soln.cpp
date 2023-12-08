class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        /**
        DP approach

        Lets say dp[i] => Min cost of reaching step i.

        dp[0] = 0 ... Start at 0 
        dp[1] = 0 ... Start at 1

        dp[n] = min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2])

        **/
        vector<long> dp(cost.size()+1, 0);
        for(int i=2;i<=cost.size(); i++){
            dp[i]=min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.size()];
    }
};