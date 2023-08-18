class Solution {
    public boolean xorGame(int[] nums) {
        int xorall = 0;
        for(int n:nums)
            xorall ^= n;
        return xorall == 0 || nums.length % 2 == 0;
    }
}