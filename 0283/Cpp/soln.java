class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int len = 0;
        for(int i:nums)
            if(i)
                nums[len++]=i;
        while(len<nums.size())
            nums[len++]=0;
    }
};