class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int cost = INT_MAX;
        int sell = INT_MIN;
        for(int price:prices){
            cost = min(cost, price);
            sell = max(sell, price-cost);
        }
        return sell;
    }
};