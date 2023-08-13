class Solution {
    public boolean isSubsequence(String s, String t) {
        int tlen = t.length();
        int slen = s.length();
        if(tlen < slen)
            return false;
        int expectedIndexS = 0;
        for(int i = 0;i < tlen && expectedIndexS < slen; i++){
            if(s.charAt(expectedIndexS) == t.charAt(i))
            expectedIndexS++;
        }
        return expectedIndexS == slen;
    }
}