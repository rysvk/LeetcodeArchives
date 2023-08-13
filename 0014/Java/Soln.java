class Solution {
    public String longestCommonPrefix(String[] strs) {
        int longestPrefixLength = 0;
        // if length of longest prefix is x,
        // the prefix is [strs[0] ... strs[x-1]]

        int wordsCnt = strs.length;
        int firstLength = strs[0].length();
        if(wordsCnt == 0)
            return "";
        
        for(int i = 0 ;i < firstLength ; i++){
            // no need for j = 0 as we compare rest of strs against strs[0]
            for(int j = 1; j < wordsCnt; j++)
                if(i == firstLength || strs[j].charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0, i);
        }
        return strs[0];
    }
}