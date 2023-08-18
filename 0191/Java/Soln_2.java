public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        for(int i = 0 ;i < 32; i++){
            if((n & 1) !=0)
                cnt ++;
            n >>= 1;
        }
        return cnt;
    }
}