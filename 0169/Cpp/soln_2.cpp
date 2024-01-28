class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int candidate = 0;
        for(int i=0,votes=0;i<nums.size();i++){
            if(!votes)
                votes=1, candidate=nums[i];
            else
                votes+= candidate==nums[i] ? 1:-1;
        }
        return candidate;
    }
};