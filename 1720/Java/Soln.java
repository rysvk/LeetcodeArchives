class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] res = new int[n];
        res[0] = first;
        for(int i = 0; i < n-1; i++)
            res[i + 1] = res[i] ^ encoded[i];
        return res;
    }
}