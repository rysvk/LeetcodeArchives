class Solution {
    public int divide(int dividend, int divisor) {
        long num = Math.abs((long)dividend);
        long den = Math.abs((long)divisor);
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1:1;
        long res = 0;
        for(int i = 31;i >= 0;i--){
            if((den << i) <= num){
                res += (1L << i);
                num -= (den << i);
            }
        }
        res *= sign; 
        if(res <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(res >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)res;
    }
}