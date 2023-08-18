class Solution {
    public int findComplement(int num) {
        int res = num;
        int mask = 1;
        while(num > 0){
            res ^=  mask;
            mask <<= 1;
            num >>= 1;
        }
        return res;
    }
}