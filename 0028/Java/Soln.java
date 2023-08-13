class Solution {
    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        if(hlen < nlen)
            return -1;
        //   0 1 2 ............................... hlen-1
        //      last search for needle =>    [x....hlen-1]
        // hlen-1 - x = nlen -1 [x..hlen-1 inclusive]  
        // x = hlen - nlen [ maximum value of i ]
        for(int i = 0;i <= hlen - nlen; i++){
            int j = 0;
            while(j < nlen && needle.charAt(j) == haystack.charAt(i+j))
                j++;
            if(j == nlen)
                return i;
        }
        return -1;
    }
}