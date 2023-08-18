class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xorarr = new int[arr.length + 1];
        xorarr[0] = 0;
        for(int i = 0;i < arr.length; i++)
            xorarr[i+1] = xorarr[i] ^ arr[i];
        int[] res = new int[queries.length];
        for(int i = 0;i < queries.length; i++){
            res[i] = xorarr[queries[i][1] + 1] ^ xorarr[queries[i][0]];
        }
        return res;
    }
}