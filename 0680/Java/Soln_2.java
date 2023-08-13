class Solution {
    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--))
                return false;
        return true;
    }
    public boolean validPalindrome(String s) {
        for(int low = 0, high = s.length() - 1; low < high; low++, high--)
            if(s.charAt(low) != s.charAt(high))
                return isPalindrome(s, low + 1, high) || isPalindrome(s, low, high - 1);
        return true;
    }
}