class Solution {
    public int[] evenOddBit(int n) {
        int[] res = {0,0};
        for(int i = 0;i < 32; i++)
            res[i%2] += (n & (1 << i)) != 0 ? 1:0; 
        return res;
    }
}