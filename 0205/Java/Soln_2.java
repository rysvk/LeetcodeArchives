class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] idxS = new int[256];
        int[] idxT = new int[256];
        for(int i = 0; i < s.length(); i++){
            if(idxS[s.charAt(i)]!=idxT[t.charAt(i)])
                return false;
            idxS[s.charAt(i)]=i+1;
            idxT[t.charAt(i)]=i+1;
            // use i+1 as i+1 > 0. is the default value in an array
            // hence using 1-indexed values serves our purpose. 
        }
        return true;
    }
}