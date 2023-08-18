class Solution {
    public boolean hasAlternatingBits(int n) {
        return ((n^=(n>>2)) & (n-1)) == 0;
    }
}