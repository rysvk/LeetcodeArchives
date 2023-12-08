class Solution {
public:
    /**
    Optimized TC: O(N), SC : O(1)
    **/
    bool isSubsequence(string s, string t) {
        if(s.length() < 1) 
          return true;
        int expectedIndex = 0;
        for(char c:t){
            if(c==s[expectedIndex])
                expectedIndex++;
            if(expectedIndex==s.size())
                return true;
        }
        return false;
    }
};