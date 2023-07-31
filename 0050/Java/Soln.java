class Solution {
    public double myPow(double x, long n) {
        if(n==0)
            return 1;
        if(x==0)
            return 0;
        if(n<0)
            x = 1/x;
        n = Math.abs(n);
        double res=1;
        while(n > 0){
            // multiply with result only if LSB is 1
            if((n & 1) != 0)
                res = res * x;
            x *= x;
            n >>= 1;
        }
        return res;
    }
}