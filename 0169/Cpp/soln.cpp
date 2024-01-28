class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int candidate = 0;
        int votes = 0;
        for(int i:nums){
            votes+= candidate==i ? 1:-1;
            if(votes<1)
                candidate=i, votes=1;
        }
        return candidate;
    }
};