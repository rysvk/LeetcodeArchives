class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder(s);
        int start = 0;
        int end = 0;
        while(start < result.length()){
            while(start < result.length() && result.charAt(start) == ' ')
                start++;
            end = start;
            while(end < result.length() && result.charAt(end) != ' ')
                end++;
            reverse(result, start, end - 1);
            start = end;
        }
        return result.toString();
    }
    public void reverse(StringBuilder s, int low, int high){
        while(low < high){
            char temp = s.charAt(low);
            s.setCharAt(low++, s.charAt(high));
            s.setCharAt(high--, temp);
        }
    }
}