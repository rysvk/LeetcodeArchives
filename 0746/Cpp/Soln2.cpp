class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        /**
        DP approach (Space optimized)
        Here we change the cost array.

        cost array has cost paid at each step.
        Let us add min(cost[i-1], cost[i-2]) to cost[i] for every i>=2 and i<n
        For reaching nth step we need (cost[n-1], cost[n-2]), hence that is our answer

        **/
        int n = cost.size();
        for(int i = 2; i < n; i++)
            cost[i]+=min(cost[i-1], cost[i-2]);
        return min(cost[n-1], cost[n-2]);
    }
};