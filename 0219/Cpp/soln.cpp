class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_set<int> seen;
        for(int i=0;i<nums.size();i++){
            if(i>k)
                seen.erase(nums[i-k-1]);
            if(!seen.insert(nums[i]).second)
                return true;
        }
        return false;
    }
};