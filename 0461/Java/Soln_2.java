class Solution {
    public int hammingDistance(int x, int y) {
        int cnt = 0;
        for(int i = 0; i < 32; i++)
            cnt += ((x & (1 << i)) ^ (y & (1 << i))) == 0 ? 0:1;
        return cnt;
    }
}