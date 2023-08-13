class Solution {
    public String reverseVowels(String s) {
        int low = 0;
        int high = s.length() - 1;
        String allVowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder(s);
        while(low < high){
            while(low < high && allVowels.indexOf(s.charAt(low)) == -1)
                low++;
            while(low < high && allVowels.indexOf(s.charAt(high)) == -1)
                high--;
            char temp = s.charAt(low);
            result.setCharAt(low++, s.charAt(high));
            result.setCharAt(high--, temp);
        }
        return result.toString();
    }
}