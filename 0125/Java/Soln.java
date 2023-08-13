class Solution {
    public boolean isAlphaNumeric(char c){
        return (c >= '0' && c<='9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <='Z');
    }

    public char toLower(char c){
        if(c < 'A' || c > 'Z')
            return c;
        return (char)(c + 32);
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            while(start < end && !isAlphaNumeric(s.charAt(start)))
                start ++;
            while(start < end && !isAlphaNumeric(s.charAt(end)))
                end --;
            if(start < end && toLower(s.charAt(start++)) != toLower(s.charAt(end--)))
                return false;
        }    
        return true;
    }
}