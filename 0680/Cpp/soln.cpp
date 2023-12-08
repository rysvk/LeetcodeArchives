class Solution {
public:
    bool isPalindrome(string& s, int low, int high){
        while(low < high)
            if(s[low++] != s[high--])
                return false;
        return true;
    }
    bool validPalindrome(string s) {
        for(int low = 0, high = s.length() - 1; low < high; low++, high--)
            if(s[low] != s[high])
                return isPalindrome(s, low + 1, high) || isPalindrome(s, low, high -1);
        return true;
    }
};