class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int len=0;
        for(int i:nums)
            if(i!=val)
                nums[len++]=i;
        return len;
    }
};