class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> charToIndexS = new HashMap();
        Map<Character, Integer> charToIndexT = new HashMap();
        // Note: int i will not work as the boxed value will be different in both maps
        for(Integer i = 0; i < s.length(); i++)
            // put in Map returns the previous value or null.
            if(charToIndexS.put(s.charAt(i), i) != charToIndexT.put(t.charAt(i), i))
                return false;
        return true;
    }
}