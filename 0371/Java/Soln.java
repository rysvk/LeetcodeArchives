class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int s = a ^ b;
            int c = a & b;
            a = s;
            b = c << 1;
        }
        return a;
    }
}